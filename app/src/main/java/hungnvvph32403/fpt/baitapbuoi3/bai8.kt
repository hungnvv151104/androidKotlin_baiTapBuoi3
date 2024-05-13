package hungnvvph32403.fpt.baitapbuoi3

class SinhVien(val hoTen: String, val tuoi: Int, val lop: String)

class TheMuon(
    val maPhieu: String,
    val ngayMuon: Int,
    val hanTra: Int,
    val soHieuSach: String,
    val sinhVien: SinhVien
) {
    fun hienThiThongTin() {
        println("Thông tin thẻ mượn:")
        println("Mã phiếu mượn: $maPhieu")
        println("Ngày mượn: $ngayMuon")
        println("Hạn trả: $hanTra")
        println("Số hiệu sách: $soHieuSach")
        println("Thông tin sinh viên:")
        println("Họ tên: ${sinhVien.hoTen}")
        println("Tuổi: ${sinhVien.tuoi}")
        println("Lớp: ${sinhVien.lop}")
        println()
    }
}

class QuanLyTheMuon {
    private val dsTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(theMuon: TheMuon) {
        dsTheMuon.add(theMuon)
    }

    fun xoaTheMuon(maPhieu: String) {
        val theMuon = dsTheMuon.find { it.maPhieu == maPhieu }
        if (theMuon != null) {
            dsTheMuon.remove(theMuon)
            println("Đã xoá thẻ mượn có mã phiếu: $maPhieu")
        } else {
            println("Không tìm thấy thẻ mượn có mã phiếu: $maPhieu")
        }
    }

    fun hienThiDanhSachTheMuon() {
        if (dsTheMuon.isEmpty()) {
            println("Không có thẻ mượn nào.")
        } else {
            println("Danh sách thẻ mượn:")
            for (theMuon in dsTheMuon) {
                theMuon.hienThiThongTin()
            }
        }
    }
}

fun main() {
    val sinhVien1 = SinhVien("Nguyễn Văn A", 20, "12A")
    val sinhVien2 = SinhVien("Trần Thị B", 19, "11B")
    val sinhVien3 = SinhVien("Trần Thị C", 12, "6c")


    val theMuon1 = TheMuon("PM001", 1, 7, "SH001", sinhVien1)
    val theMuon2 = TheMuon("PM002", 2, 8, "SH002", sinhVien2)
    val theMuon3 = TheMuon("PM003", 2, 8, "SH003", sinhVien3)

    val quanLy = QuanLyTheMuon()

    quanLy.themTheMuon(theMuon1)
    quanLy.themTheMuon(theMuon2)
    quanLy.themTheMuon(theMuon3)


    quanLy.xoaTheMuon("PM002")

    quanLy.hienThiDanhSachTheMuon()
}