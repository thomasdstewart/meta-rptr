FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += " \
    file://vconsole.conf \
    file://dhcp.network \
"

FILES_${PN} += " ${sysconfdir}/vconsole.conf dhcp.network "

do_install_append() {
    install -m 0644 ${WORKDIR}/vconsole.conf ${D}${sysconfdir}/vconsole.conf
    install -d ${D}${prefix}/lib/systemd/network/
    install -m 0644 ${WORKDIR}/dhcp.network ${D}${prefix}/lib/systemd/network/
}
