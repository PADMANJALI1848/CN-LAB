import socket as sock

client_socket = sock.socket(sock.AF_INET , sock.SOCK_STREAM)

server_addrress = ('localhost',12345)
client_socket.connect(server_addrress)

file_name = input("Enter the file name to be read : ").encode()
client_socket.sendall(file_name)

#Receive
file_contents = b''
while True:
    data = client_socket.recv(1024)
    if not data:
        break
    file_contents+=data
print(file_contents.decode())