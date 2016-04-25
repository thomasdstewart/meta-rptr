do_install_append() {
    sed -i "s^key_mgmt=NONE^ssid=\"${WIFI_SSID}\"\n        psk=\"${WIFI_PSK}\"^" \
        ${D}${sysconfdir}/wpa_supplicant.conf
}
