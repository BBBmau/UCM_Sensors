import bluetooth

server = bluetooth.BluetoothSocket(bluetooth.RFCOMM)
host = ""
port = 1
print("Bluetooth Socket Created")

try:
	server.bind((host,port))
	print("Bluetooth Binding Completed")
except:
	print("Bluetooth Binding Failed") 
	server_sock.listen(1)
print("Running")

client_sock, address = server_sock.accept()
print("Accepted connection from ", str(address))

while True:
	recvdata = client_sock.recv(1024)
	print("Received \"%s\" through Bluetooth"%recvdata)
	
	if(recvdata == "Q"):
		print("Exiting")
		break

client_sock.close()
server_sock.close()
	
