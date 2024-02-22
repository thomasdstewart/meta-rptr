DESCRIPTION = "rptr packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS:${PN} = "\
    iptables \
    iw \
    kernel-modules \
    linux-firmware \
    readkey \
    swupdate \
    tapecontrol \
    wireless-regdb \
    wpa-supplicant \
"
