FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += " \
    file://e.network \
    file://w.network \
"
do_install_append() {
    install -d ${D}${prefix}/lib/systemd/network/
    install -m 0644 ${WORKDIR}/e.network ${D}${prefix}/lib/systemd/network/
    install -m 0644 ${WORKDIR}/w.network ${D}${prefix}/lib/systemd/network/
}
