do_install_append() {
        #firmware is some 500M, I only need: rt2870.bin
        rm -rf ${D}${nonarch_base_libdir}/firmware/[a-q,s-z]*
}
