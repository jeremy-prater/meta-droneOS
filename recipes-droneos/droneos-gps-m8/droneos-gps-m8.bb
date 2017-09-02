DESCRIPTION = "droneOS-gps-m8"
LICENSE = "CLOSED"

inherit systemd
inherit cmake_qt5
inherit qmake5_paths


DEPENDS = " \
    qtbase \
    qtlocation \
"

RDEPENDS_${PN} += " \
    qtbase \
    qtlocation \
"

SRCBRANCH = "master"
SRCREV = "b0f382767a1c7d19343c51a25f621012ca52674d"

SRC_URI = "git://git@github.com/Trail-Tech/polaris-audio.git;protocol=ssh;branch=${SRCBRANCH}"
#SRC_URI += "file://com.polaris.audio.conf"
#SRC_URI += "file://polaris-audio.service"

#S = "${WORKDIR}/git"

EXTRA_OECMAKE=""

do_install_append(){
    # D-Bus configuration file
    #install -m 0755 -d ${D}/${sysconfdir}/dbus-1/system.d
    #install -m 0644 ${WORKDIR}/com.polaris.audio.conf ${D}/${sysconfdir}/dbus-1/system.d
    #install -d ${D}${systemd_system_unitdir}
    #install -m 0644 ${WORKDIR}/polaris-audio.service ${D}${systemd_system_unitdir}
}

#SYSTEMD_SERVICE_${PN} = "droneOS-gps.service"

#FILES_${PN} += "${systemd_system_unitdir}/droneOS-gps.service"

###############################################################################
#
# User/group for audio daemon
#
#inherit useradd
#USERADD_PACKAGES += "${PN}"
#GROUPADD_PARAM_${PN} = "-g 300 polaris-audio"
#USERADD_PARAM_${PN} = "-M -g 300 -u 300 -s /bin/false polaris-audio"
#
###############################################################################

inherit externalsrc
EXTERNALSRC = "/home/jeremy/src/gps-m8"
