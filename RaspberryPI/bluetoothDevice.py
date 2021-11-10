import bluetooth

print(bluetooth.lookup_name("60:B7:6E:34:15:C5"))

nearby_devices = bluetooth.discover_devices(lookup_names=True, duration=5)
print("Found {} devices.".format(len(nearby_devices)))

for addr, name in nearby_devices:
    print("  {} - {}".format(addr, name))
