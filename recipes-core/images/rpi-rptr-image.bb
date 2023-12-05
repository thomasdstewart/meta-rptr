include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES:append = " ssh-server-dropbear allow-root-login read-only-rootfs"
IMAGE_FEATURES:remove = " splash"
IMAGE_INSTALL:append = " rptr-packagegroup"

REPRODUCIBLE_TIMESTAMP_ROOTFS = "${@time.strftime('%s',time.gmtime())}"

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p '${ROOT_PASSWORD_HASH}' root;"
