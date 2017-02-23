

A small code snippet to help you in the coding for sniffing and spoofing

void got_packet(u_char *args, const struct pcap_pkthdr *header, const u_char *packet)
{

    static int count = 1;                   /* packet counter */

    int s;    // socket
    const int on = 1;

    /* declare pointers to packet headers */
    const struct ether_header *ethernet = (struct ether_header*)(packet);
    const struct ip *iph;              /* The IP header */
    const struct icmp *icmph;            /* The ICMP header */
    struct sockaddr_in dst;

    int size_ip;
    
    /* define/compute ip header offset */
    iph = (struct ip*)(packet + SIZE_ETHERNET);
    size_ip = iph->ip_hl*4;    // size of ip header

    if (iph->ip_p != IPPROTO_ICMP || size_ip < 20) {  // disregard other packets
        return;
    }
    
    /* define/compute icmp header offset */
    icmph = (struct icmp*)(packet + SIZE_ETHERNET + size_ip);
        
    /* print source and destination IP addresses */
    printf("%d) ICMP Sniff: from--%s\n", count, inet_ntoa(iph->ip_src) );      
        
    /* Construct the spoof packet and allocate memory with the lengh of the datagram */
    char buf[htons(iph->ip_len)];
    struct spoof_packet *spoof = (struct spoof_packet *) buf;

    /* Initialize the structure spoof by copying everything in request packet to spoof packet*/
    memcpy(buf, iph, htons(iph->ip_len));
    
    /* Modify ip header */

       //swap the destination ip address and source ip address
    (spoof->iph).ip_src = iph->ip_dst;
    (spoof->iph).ip_dst = iph->ip_src;

        //recompute the checksum, you can leave it to 0 here since RAW socket will compute it for you.
    (spoof->iph).ip_sum = 0;

    /* Modify icmp header */
    
    // set the spoofed packet as echo-reply
    (spoof->icmph).icmp_type = ICMP_ECHOREPLY;
    // always set code to 0
    (spoof->icmph).icmp_code = 0;

    (spoof->icmph).icmp_cksum = 0;    // should be set as 0 first to recalculate.
    (spoof->icmph).icmp_cksum = in_cksum((unsigned short *) &(spoof->icmph), sizeof(spoof->icmph));
    //print the forged packet information
    printf("forged packet src is %s\n",inet_ntoa((spoof->iph).ip_src));
    printf("forged packet det is %s\n\n",inet_ntoa((spoof->iph).ip_dst));        
      
    memset(&dst, 0, sizeof(dst));
        dst.sin_family = AF_INET;
        dst.sin_addr.s_addr = (spoof->iph).ip_dst.s_addr;

    /* create RAW socket */
    if((s = socket(AF_INET, SOCK_RAW, IPPROTO_RAW)) < 0) {
        printf("socket() error");
        return;
    }
 
    /* socket options, tell the kernel we provide the IP structure */
    if(setsockopt(s, IPPROTO_IP, IP_HDRINCL, &on, sizeof(on)) < 0) {
        printf("setsockopt() for IP_HDRINCL error");
        return;
    }

    if(sendto(s, buf, sizeof(buf), 0, (struct sockaddr *) &dst, sizeof(dst)) < 0) {
        printf("sendto() error");
    }

    close(s);    // free resource
    
    //free(buf);
    count++;
return;
}
