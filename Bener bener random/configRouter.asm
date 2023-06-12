ena
config terminal
hostname Syaikhul
ena secret jarkom
inter fastethernet 0/0
ip address "ip" "subnet"
no shut
inter fastethernet 0/1
ip address "ip" "subnet"
no shut
exit
exit
copy running-config startup-config
write