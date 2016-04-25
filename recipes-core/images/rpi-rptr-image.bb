# Base this image on rpi-hwup-image
include recipes-core/images/rpi-hwup-image.bb

IMAGE_FEATURES += "ssh-server-dropbear read-only-rootfs"
IMAGE_FEATURES_remove = " debug-tweaks splash"
IMAGE_INSTALL_append = " packagegroup-rptr"

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P ${ROOT_PASSWORD} root;"
