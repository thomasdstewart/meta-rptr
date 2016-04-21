SUMMARY = "Firewall"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    iptables \
"

SRC_URI = "file://firewall"
S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "firewall"
INITSCRIPT_PARAMS = "defaults 99"

do_install() {
        install -d ${D}${sysconfdir} ${D}${sysconfdir}/init.d
        install -m 0755 firewall ${D}${sysconfdir}/init.d
}
