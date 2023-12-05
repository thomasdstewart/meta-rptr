FILES:${PN} += "${systemd_unitdir}/system/multi-user.target.wants/wpa_supplicant@wlan0.service "

do_install:append() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    echo "network={\n    ssid=\"${WIFI_SSID}\"\n    psk=\"${WIFI_PSK}\"\n}" > ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    install -d  ${D}${systemd_unitdir}/system/multi-user.target.wants
    ln -s ../wpa_supplicant@.service ${D}${systemd_unitdir}/system/multi-user.target.wants/wpa_supplicant@wlan0.service
}
