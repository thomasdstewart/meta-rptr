SUMMARY = "Tape Control"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    python-flask \
    rpi-gpio \
    python-pprint \
"

SRC_URI = "file://tapecontrol file://init file://tapecontrol.service"

inherit update-rc.d systemd

INITSCRIPT_NAME = "tapecontrol"
INITSCRIPT_PARAMS = "defaults 90 10"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "tapecontrol.service"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 init ${D}${sysconfdir}/init.d/tapecontrol

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 tapecontrol.service ${D}${systemd_unitdir}/system

    install -d ${D}${bindir}
    install -m 0755 tapecontrol ${D}${bindir}
}
