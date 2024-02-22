DESCRIPTION = "Example image demonstrating how to build SWUpdate compound image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

include recipes-extended/images/swupdate-image.inc
inherit swupdate

SRC_URI = "file://emmcsetup.lua file://sw-description"

IMAGE_DEPENDS = "rpi-rptr-image"
SWUPDATE_IMAGES = "rpi-rptr-image"
SWUPDATE_IMAGES_FSTYPES[rpi-rptr-image] = ".ext4.gz"
