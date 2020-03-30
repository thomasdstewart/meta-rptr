FILESEXTRAPATHS_prepend := "${THISDIR}/iptables:"

SRC_URI += " \
    file://rules \
"
do_install_append() {
    install -m 0644 ${WORKDIR}/rules ${D}${sysconfdir}/iptables/iptables.rules
}
