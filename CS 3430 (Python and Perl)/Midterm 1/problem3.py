class NetworkNode:
    def __init__(self, load=0):
        self.__msg = 0
        self.__load = load

    def receive_message(self, msg):
        self.__msg = msg
    def send_message(self, network_node, msg):
        network_node.receive_message(msg)
    def send_load(self, network_node):
        self.send_message(network_node, self.__load)
    def get_message(self):
        return self.__msg
    def return_average(self):
        return (self.__msg + self.__load) / 2

def average_load(nn01, nn02):
    nn01.send_load(nn02)
    return nn02.return_average()
