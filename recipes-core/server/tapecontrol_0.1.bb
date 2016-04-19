SUMMARY = "Tape Control"
#SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    python-flask \
    rpi-gpio \
    python-pprint \
"


SRC_URI = "file://tapecontrol.py"

S = "${WORKDIR}"

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 tapecontrol.py ${D}${bindir}
}
