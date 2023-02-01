import socket

server_socket = socket.socket(socket.AF_INET , socket.SOCK_DGRAM)
server_address = ('localhost' , 12345)
server_socket.bind(server_address)

print("Server is listening {} : {}".format(*server_address))

while True:
    data , client_address = server_socket.recvfrom(4096)
    file_name = data.decode()

    try :
        with open(file_name , 'rb') as file :
            file_contents = file.read()
            server_socket.sendto(file_contents , client_address)
    except FileNotFoundError:
        server_socket.sendto(b'File Not Found',client_address)