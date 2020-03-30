include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "ssh-server-dropbear read-only-rootfs"
IMAGE_FEATURES_remove = " debug-tweaks splash"
IMAGE_INSTALL_append = " packagegroup-rptr"

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P ${ROOT_PASSWORD} root;"
