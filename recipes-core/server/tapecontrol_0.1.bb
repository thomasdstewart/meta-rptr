SUMMARY = "Tape Control"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    python-flask \
    rpi-gpio \
    python-pprint \
"

SRC_URI = "file://tapecontrol file://init"
S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "tapecontrol"
INITSCRIPT_PARAMS = "defaults 99"

do_install() {
        install -d ${D}${sysconfdir} ${D}${sysconfdir}/init.d ${D}${bindir}
        install -m 0755 init ${D}{${sysconfdir}/init.d/tapecontrol
        install -m 0755 tapecontrol ${D}${bindir}
}
