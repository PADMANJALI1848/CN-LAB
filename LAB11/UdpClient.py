import socket

client_socket = socket.socket(socket.AF_INET , socket.SOCK_DGRAM)
server_address = ('localhost' , 12345)

file_name = input("Enter the file name to be read : ").encode()
client_socket.sendto(file_name , server_address)

fileContents  , _ =  client_socket.recvfrom(4096)

print(fileContents.decode())