if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'false', 'true', d)}; then
    FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
fi
