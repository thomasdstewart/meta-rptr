do_install_append() {
        #firmware is some 500M, I only need: rt2870.bin
        find ${D}${nonarch_base_libdir}/firmware/ -not -name 'firmware' -a -not -name 'rt2870.bin' -a -not -name 'LICENCE.ralink-firmware.txt' -a -not -name 'LICENCE.rockchip' -a -not -name 'rtw88*' -a -not -name 'WHENCE' -delete
}
