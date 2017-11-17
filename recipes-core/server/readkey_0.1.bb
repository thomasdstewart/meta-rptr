SUMMARY = "Read Key"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} += " \
    python-evdev \
    python-stringold \
    python-ctypes \
    python-urllib3 \
    python-pprint \
"

SRC_URI = "file://readkey file://init file://readkey.service"

inherit update-rc.d systemd

INITSCRIPT_NAME = "readkey"
INITSCRIPT_PARAMS = "defaults 90 10"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "readkey.service"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 init ${D}${sysconfdir}/init.d/readkey

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 readkey.service ${D}${systemd_unitdir}/system

    install -d ${D}${bindir} 
    install -m 0755 readkey ${D}${bindir}
}
