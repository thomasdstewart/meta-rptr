SUMMARY = "Read Key"
#SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    python-evdev \
    python-stringold \
    python-ctypes \
    python-urllib3 \
    python-pprint \
"

SRC_URI = "file://readkey.py"

S = "${WORKDIR}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "file://readkey"
INITSCRIPT_PARAMS = "defaults 99"


do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 readkey.py ${D}${bindir}
}
