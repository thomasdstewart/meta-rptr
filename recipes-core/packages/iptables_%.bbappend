FILESEXTRAPATHS:prepend := "${THISDIR}/iptables:"

SRC_URI:append = " file://iptables.rules file://ip6tables.rules"

do_install:append() {
    install -m 0644 "${WORKDIR}/iptables.rules" \
        "${D}${sysconfdir}/iptables/iptables.rules"
    install -m 0644 "${WORKDIR}/ip6tables.rules" \
        "${D}${sysconfdir}/iptables/ip6tables.rules"
}
