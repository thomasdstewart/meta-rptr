FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += " \
    file://dhcp.network \
    file://vconsole.conf \
"

FILES_${PN} += " ${sysconfdir}/vconsole.conf "

do_install_append() {
    install -m 0644 ${WORKDIR}/vconsole.conf ${D}${sysconfdir}/vconsole.conf
    #install -d ${D}${prefix}/lib/systemd/network/
    #install -m 0644 ${WORKDIR}/e.network ${D}${prefix}/lib/systemd/network/
    #install -m 0644 ${WORKDIR}/w.network ${D}${prefix}/lib/systemd/network/
}
