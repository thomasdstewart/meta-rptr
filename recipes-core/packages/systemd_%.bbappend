FILESEXTRAPATHS:prepend := "${THISDIR}/systemd:"

SRC_URI:append = " file://vconsole.conf file://dhcp.network"

FILES:${PN} += " ${sysconfdir}/vconsole.conf dhcp.network"

do_install:append() {
    install -m 0644 ${UNPACKDIR}/vconsole.conf ${D}${sysconfdir}/vconsole.conf
    install -d ${D}${prefix}/lib/systemd/network/
    install -m 0644 ${UNPACKDIR}/dhcp.network ${D}${prefix}/lib/systemd/network/
    ln -s /dev/null ${D}${sysconfdir}/systemd/network/99-default.link
}
