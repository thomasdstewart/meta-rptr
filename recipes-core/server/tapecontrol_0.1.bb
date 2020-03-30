SUMMARY = "Tape Control"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    python3 \
    python3-flask \
    rpi-gpio \
    python3-pprint \
"

SRC_URI = "file://tapecontrol.service file://tapecontrol"
S = "${WORKDIR}"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "tapecontrol.service"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 tapecontrol.service ${D}${systemd_unitdir}/system

    install -d ${D}${bindir}
    install -m 0755 tapecontrol ${D}${bindir}
}
