FILESEXTRAPATHS_prepend := "${THISDIR}/dropbear:"

SRC_URI += " \
    file://dropbear.default \
"
do_install_append() {
    install -m 0644 ${WORKDIR}/dropbear.default ${D}${sysconfdir}/default/dropbear.new
}
