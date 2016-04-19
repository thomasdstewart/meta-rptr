# Base this image on rpi-hwup-image
include recipes-core/images/rpi-hwup-image.bb

#SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_INSTALL_append = " packagegroup-rptr"

DISTRO_FEATURES_append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""
