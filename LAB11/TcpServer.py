import socket as sock

server_socket = sock.socket(sock.AF_INET , sock.SOCK_STREAM)

server_address = ('localhost',12345)
server_socket.bind(server_address)

server_socket.listen(1)
print("Server is listening {} : {}".format(*server_address))

while True :
    print("Waiting for connection")
    client_socket , client_address = server_socket.accept()
    print("Accepted Connection {} : {}".format(*client_address))
    try:
        file_name = client_socket.recv(1024).decode()
        with open(file_name , 'rb') as file:
            file_contents = file.read()
            client_socket.sendall(file_contents)
    except FileNotFoundError:
        error_msg = 'File Not Found\n'.encode()
        client_socket.sendall(error_msg)

    finally:
        client_socket.close()

