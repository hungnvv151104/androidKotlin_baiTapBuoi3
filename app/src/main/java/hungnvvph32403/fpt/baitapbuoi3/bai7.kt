package hungnvvph32403.fpt.baitapbuoi3

open class Nguoi(val hoTen: String, val tuoi: Int, val queQuan: String) {}

class CBGV(val maGV: String, hoTen: String, tuoi: Int, queQuan: String) : Nguoi(hoTen, tuoi, queQuan) {
    var luongCung: Double = 0.0
    var luongThuong: Double = 0.0
    var tienPhat: Double = 0.0

    fun tinhLuongThucLinh(): Double {
        val luongThuc = luongCung + luongThuong - tienPhat
        return luongThuc
    }
}

class QuanLyCBGV {
    private val danhSachCBGV: MutableList<CBGV> = mutableListOf()

    fun themCBGV(gv: CBGV) {
        danhSachCBGV.add(gv)
    }

    fun xoaCBGV(maGV: String) {
        val gv = danhSachCBGV.firstOrNull { it.maGV == maGV }
        if (gv != null) {
            danhSachCBGV.remove(gv)
            println("Đã xóa giáo viên có mã số $maGV")
        } else {
            println("Không tìm thấy giáo viên có mã số $maGV")
        }
    }

    fun inDanhSachCBGV() {
        if (danhSachCBGV.isEmpty()) {
            println("Danh sách giáo viên rỗng")
        } else {
            println("Danh sách giáo viên:")
            for (gv in danhSachCBGV) {
                println("Mã số: ${gv.maGV}")
                println("Họ tên: ${gv.hoTen}")
                println("Tuổi: ${gv.tuoi}")
                println("Quê quán: ${gv.queQuan}")
                println("---------------")
            }
        }
    }

}

fun main() {
    val quanLyCBGV = QuanLyCBGV()

    val gv1 = CBGV("GV001", "Nguyễn Văn A", 35, "Hà Nội")
    gv1.luongCung = 7000000.0
    gv1.luongThuong = 1000000.0
    gv1.tienPhat = 600000.0
    val gv2 = CBGV("GV002", "Trần Thị B", 40, "Hồ Chí Minh")
    quanLyCBGV.themCBGV(gv1)
    quanLyCBGV.themCBGV(gv2)

    quanLyCBGV.xoaCBGV("GV002")

    val luongThucLinh = gv1.tinhLuongThucLinh()

    quanLyCBGV.inDanhSachCBGV()

    println("Lương thực lĩnh của giáo viên ${gv1.hoTen}: $luongThucLinh")
}