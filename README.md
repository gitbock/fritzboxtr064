# OpenHAB Fritzbox Binding using TR064 protocol


Hi,
I created a binding for communication with fritzbox using SOAP requests (TR064 protocol). I tested it on

* 7270
* 7360SL (v6.30)
* 7390

Features:

* detect if MAC is online in network (presence detection)
* switching on/off 2,4Hz Wifi, 5GHz Wifi and Guest Wifi (if any)
* getting external IP address of fbox
* getting fbox model name

## Item Binding
```
String  fboxName            "FBox Modell [%s]"          {fritzboxtr064="modelName"}
String  fboxWanIP           "FBox WAN IP [%s]"          {fritzboxtr064="wanip"}
Switch  fboxWifi24          "2,4GHz Wifi"               {fritzboxtr064="wifi24Switch"}
Switch  fboxWifi50          "5,0GHz Wifi"               {fritzboxtr064="wifi50Switch"}
Switch  fboxGuestWifi       "Guest Wifi"                {fritzboxtr064="wifiGuestSwitch"}
Contact cFboxMacOnline      "Anwesend (WLAN) %d"   {fritzboxtr064="maconline:11-11-11-11-11-11" }


```

## openhab.cfg
Add the following to your openhab.cfg and configure the parameters:


```
############################# Fritz!Box TR064 Binding #######################################
#
## Binding for accessing FritzBoxes using the TR064 protocol. Uses http(s) requests.

# URL. Either use http://<fbox-ip>:49000 or https://<fbox-ip>:49443 (https preferred!)
fritzboxtr064:url=https://192.168.178.1:49443

# Refresh Interval (60000ms default)
fritzboxtr064:refresh=60000

# User Name (only use this value if you configured a user in fbox webui/config!)
# If this parameter is missing, "dslf-config" is used as default username
# It is recommended to to switch to authentication by username in fritzbox config
# and add a separate config user for this binding.
#fritzboxtr064:user=dslf-config

# PW
fritzboxtr064:pass=Fr!tZP@ssw0rd
```

## Known issues
* maconline is (sometimes?) not supported for static addressing (not using DHCP in fritzbox)

## Debug Logging
insert the following line into you logback.xml or logback_debug.xml
```
<!-- FritzBox TR064 binding -->
<logger name="org.openhab.binding.fritzboxtr064" level="DEBUG" />
```
