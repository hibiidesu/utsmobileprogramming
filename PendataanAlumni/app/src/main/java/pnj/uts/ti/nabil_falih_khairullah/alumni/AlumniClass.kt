package pnj.uts.ti.nabil_falih_khairullah.alumni

data class AlumniClass(
    var id: Int = java.util.Random().nextInt(),
    var nim: String = "",
    var name: String = "",
    var bdayPlace: String = "",
    var bdayDate: String = "",
    var address: String = "",
    var religion: String = "",
    var phone: String = "",
    var entryYear: String = "",
    var gradYear: String = "",
    var job: String = "",
    var position: String = "",
)