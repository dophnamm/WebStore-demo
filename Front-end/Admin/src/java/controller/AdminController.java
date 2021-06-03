/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dataacces.ChiTietDonHangDA;
import dataacces.DonHangDA;
import dataacces.KhachHangDA;
import dataacces.NhaCungCapDA;
import dataacces.NhomSanPhamDA;
import dataacces.QuangTriDA;
import dataacces.SanPhamDA;
import dataacces.ThanhToanDA;
import dataacces.TinTucDA;
import dataacces.VanChuyenDA;
import entities.ChiTietDonHang;
import entities.DonHang;
import entities.KhachHang;
import entities.NhaCungCap;
import entities.NhomSanPham;
import entities.QuanTri;
import entities.QuangCao;
import entities.SanPham;
import entities.ThanhToan;
import entities.VanCHuyen;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nguye
 */
@Controller

public class AdminController {
//nhóm sản phẩm

    @RequestMapping(value = "/Home")
    public String homeAdmin(Model model, Integer offset, Integer maxResult) {

        NhomSanPhamDA da = new NhomSanPhamDA();
        List<NhomSanPham> listdm = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllnsp", listdm);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhomSanPhamDA().getNumberProductDetail());
        return "home";
    }

    @RequestMapping(value = "/taomoinsp")
    public String createNhomSP(Model model) {
        NhomSanPham nsp = new NhomSanPham();
        model.addAttribute("nhomsanpham", nsp);
        return "themnhomsanpham";
    }

    @RequestMapping(value = "luumoinsp", method = RequestMethod.POST)
    public String saveNhomSP(String tenNhomSp, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        NhomSanPham nsp = new NhomSanPham();
        nsp.setTenNhomSp(tenNhomSp);
        nsp.setTrangThai(trangThai);
        new NhomSanPhamDA().insert(nsp);
        NhomSanPhamDA da = new NhomSanPhamDA();
        List<NhomSanPham> listdm = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllnsp", listdm);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhomSanPhamDA().getNumberProductDetail());
        return "home";
    }

    @RequestMapping(value = "/updatennsp")
    public String updatenhomsp(int maNhomSp, Model model) {
        NhomSanPhamDA da = new NhomSanPhamDA();
        NhomSanPham nsp = da.getById(maNhomSp);
        model.addAttribute("nhomsanpham", nsp);
        return "suanhomsanpham";
    }

    @RequestMapping(value = "suanhomSP", method = RequestMethod.POST)
    public String updatenhomsanpham(int maNhomSp, String tenNhomSp, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        NhomSanPham nsp = new NhomSanPham();
        nsp.setMaNhomSp(maNhomSp);
        nsp.setTenNhomSp(tenNhomSp);
        nsp.setTrangThai(trangThai);
        new NhomSanPhamDA().update(nsp);
        NhomSanPhamDA da = new NhomSanPhamDA();
        List<NhomSanPham> listdm = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllnsp", listdm);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhomSanPhamDA().getNumberProductDetail());
        return "home";
    }

    @RequestMapping(value = "/xoanhomsanpham")
    public String deletenhomSP(int maNhomSp, String tenNhomSp, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        NhomSanPhamDA da = new NhomSanPhamDA();
        NhomSanPham nsp = new NhomSanPham();
        nsp.setMaNhomSp(maNhomSp);
        nsp.setTenNhomSp(tenNhomSp);
        nsp.setTrangThai(false);
        new NhomSanPhamDA().delete(nsp);
        List<NhomSanPham> listdm = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllnsp", listdm);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhomSanPhamDA().getNumberProductDetail());
        return "home";
    }

    @RequestMapping(value = "/timtheotennhomsp")
    public String searchTenNhomSP(String tenNhomSp, Model model) {
        NhomSanPhamDA da = new NhomSanPhamDA();
        List<NhomSanPham> list = da.search(tenNhomSp);
        model.addAttribute("getAllnsp", list);
        return "home";
    }

    @RequestMapping(value = "/chitietnhomSP")
    public String detailNhomSP(int maNhomSp, Model model) {
        NhomSanPhamDA da = new NhomSanPhamDA();
        NhomSanPham nsp = da.getById(maNhomSp);
        model.addAttribute("nsp", nsp);
        return "chitietnhomsanpham";
    }

    /*Phương thức thanh toán*/
    @RequestMapping(value = "/ThanhToan")
    public String getAll(Model model, Integer offset, Integer maxResult) {
        ThanhToanDA da = new ThanhToanDA();
        List<ThanhToan> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAlltt", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new ThanhToanDA().getNumberProductDetail());
        return "thanhtoan";
    }

    @RequestMapping(value = "/taomoi")
    public String create(Model model) {
        ThanhToan tt = new ThanhToan();
        model.addAttribute("thanhtoan", tt);
        return "themthanhtoan";
    }

    @RequestMapping(value = "luumoi", method = RequestMethod.POST)
    public String saveThanhToan(String tenTt, String mota, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        ThanhToan tt = new ThanhToan();
        tt.setTenTt(tenTt);
        tt.setMota(mota);
        tt.setTrangThai(trangThai);
        new ThanhToanDA().insert(tt);
        ThanhToanDA da = new ThanhToanDA();
        List<ThanhToan> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAlltt", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new ThanhToanDA().getNumberProductDetail());
        return "thanhtoan";
    }

    @RequestMapping(value = "/updatethanhtoan")
    public String update(int maTt, Model model) {
        ThanhToanDA da = new ThanhToanDA();
        ThanhToan tt = da.getById(maTt);
        model.addAttribute("thanhtoan", tt);
        return "suathanhtoan";
    }

    @RequestMapping(value = "sua", method = RequestMethod.POST)
    public String saveupdate(int maTt, String tenTt, String mota, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        ThanhToan tt = new ThanhToan();
        tt.setMaTt(maTt);
        tt.setMota(mota);
        tt.setTenTt(tenTt);
        tt.setTrangThai(trangThai);
        new ThanhToanDA().update(tt);
        ThanhToanDA da = new ThanhToanDA();
        List<ThanhToan> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAlltt", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new ThanhToanDA().getNumberProductDetail());
        return "thanhtoan";
    }

    @RequestMapping(value = "/chitiet")
    public String detailthanhtoan(int maTt, Model model) {
        ThanhToanDA da = new ThanhToanDA();
        ThanhToan tt = da.getById(maTt);
        model.addAttribute("tt", tt);
        return "chitietthanhtoan";
    }

    @RequestMapping(value = "/xoathanhtoan")
    public String delete(int maTt, String tenTt, String mota, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        ThanhToan tt = new ThanhToan();
        ThanhToanDA ttda = new ThanhToanDA();
        tt.setMaTt(maTt);
        tt.setMota(mota);
        tt.setTenTt(tenTt);
        tt.setTrangThai(false);
        new ThanhToanDA().delete(tt);
        List<ThanhToan> data = ttda.getProPage1(offset, maxResult);
        model.addAttribute("getAlltt", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new ThanhToanDA().getNumberProductDetail());
        return "thanhtoan";
    }

    @RequestMapping(value = "/timtheotentt")
    public String searchtitle(String tenTt, Model model) {
        ThanhToanDA da = new ThanhToanDA();
        List<ThanhToan> list = da.search(tenTt);
        model.addAttribute("getAlltt", list);
        return "thanhtoan";
    }

    /*Phương thức vận chuyển*/
    @RequestMapping(value = "/VanChuyen")
    public String getAllVC(Model model, Integer offset, Integer maxResult) {
        VanChuyenDA da = new VanChuyenDA();
        List<VanCHuyen> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllvc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new VanChuyenDA().getNumberProductDetail());
        return "vanchuyen";
    }

    @RequestMapping(value = "/taomoivc")
    public String createVanChuyen(Model model) {
        VanCHuyen vc = new VanCHuyen();
        model.addAttribute("vanchuyen", vc);
        return "themvchuyen";
    }

    @RequestMapping(value = "luumoivc", method = RequestMethod.POST)
    public String saveVanChuyen(String tenVc, String mota, double gia,boolean trangThai, Model model, Integer offset, Integer maxResult) {
        VanCHuyen vc = new VanCHuyen();
        vc.setTenVc(tenVc);
        vc.setMota(mota);
        vc.setGia(gia);
        vc.setTrangThai(trangThai);
        new VanChuyenDA().insert(vc);
        VanChuyenDA da = new VanChuyenDA();
        List<VanCHuyen> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllvc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new VanChuyenDA().getNumberProductDetail());
        return "vanchuyen";
    }

    @RequestMapping(value = "/updatevanchuyen")
    public String updatevc(int maVc, Model model) {
        VanChuyenDA da = new VanChuyenDA();
        VanCHuyen vc = da.getById(maVc);
        model.addAttribute("vanchuyen", vc);
        return "suavanchuyen";
    }

    @RequestMapping(value = "suavc", method = RequestMethod.POST)
    public String updatevanchuyen(int maVc, String tenVc, String mota,double gia, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        VanCHuyen vc = new VanCHuyen();
        vc.setMaVc(maVc);
        vc.setTenVc(tenVc);
        vc.setMota(mota);
        vc.setGia(gia);
        vc.setTrangThai(trangThai);
        VanChuyenDA da = new VanChuyenDA();
        List<VanCHuyen> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllvc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new VanChuyenDA().getNumberProductDetail());
        new VanChuyenDA().update(vc);
        return "vanchuyen";
    }

    @RequestMapping(value = "/xoavc")
    public String deletevc(int maVc, String tenVc, String mota,double gia, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        VanCHuyen vc = new VanCHuyen();
        vc.setMaVc(maVc);
        vc.setTenVc(tenVc);
        vc.setMota(mota);
        vc.setGia(gia);
        vc.setTrangThai(false);
        VanChuyenDA da = new VanChuyenDA();
        List<VanCHuyen> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllvc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new VanChuyenDA().getNumberProductDetail());
        new VanChuyenDA().delete(vc);
        return "vanchuyen";

    }

    @RequestMapping(value = "/timtheotenvc")
    public String searchTenVC(String tenVc, Model model) {
        VanChuyenDA da = new VanChuyenDA();
        List<VanCHuyen> list = da.search(tenVc);
        model.addAttribute("getAllvc", list);
        return "vanchuyen";
    }

    @RequestMapping(value = "/chitietvanchuyen")
    public String detailvanchuyen(int maVc, Model model) {
        VanChuyenDA da = new VanChuyenDA();
        VanCHuyen vc = da.getById(maVc);
        model.addAttribute("vc", vc);
        return "chitietvc";
    }

    //Tin tức
    @RequestMapping(value = "/TinTuc")
    public String getAllTinTuc(Model model, Integer offset, Integer maxResult) {
        TinTucDA da = new TinTucDA();
        List<QuangCao> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllqc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new TinTucDA().getNumberProductDetail());
        return "tintuc";
    }

    @RequestMapping(value = "/taomoitintuc")
    public String createTinTuc(Model model) {
        QuangCao qc = new QuangCao();
        model.addAttribute("quangcao", qc);
        return "themtintuc";
    }

    @RequestMapping(value = "luumoitintuc", method = RequestMethod.POST)
    public String saveTinTuc(String tenQc, String anh, double gia, String nhaSanXuat, String mota, boolean trangThai, Model model, Integer offset, Integer maxResult) {

        QuangCao qc = new QuangCao();
        qc.setTenQc(tenQc);
        qc.setAnh(anh);
        qc.setGia(gia);
        qc.setNhaSanXuat(nhaSanXuat);
        qc.setMota(mota);
        qc.setTrangThai(trangThai);
        new TinTucDA().insert(qc);
        TinTucDA da = new TinTucDA();
        List<QuangCao> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllqc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new TinTucDA().getNumberProductDetail());
        return "tintuc";
    }

    @RequestMapping(value = "/updatetintuc")
    public String updatetintuc(int maQc, Model model) {
        TinTucDA da = new TinTucDA();
        QuangCao qc = da.getById(maQc);
        model.addAttribute("tintuc", qc);
        return "suatintuc";
    }

    @RequestMapping(value = "suatintuc", method = RequestMethod.POST)
    public String updatetintuc(int maQc, String tenQc, String anh, double gia, String nhaSanXuat, String mota, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        QuangCao qc = new QuangCao();
        qc.setMaQc(maQc);
        qc.setTenQc(tenQc);
        qc.setAnh(anh);
        qc.setGia(gia);
        qc.setNhaSanXuat(nhaSanXuat);
        qc.setMota(mota);
        qc.setTrangThai(trangThai);
        new TinTucDA().update(qc);
        TinTucDA da = new TinTucDA();
        List<QuangCao> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllqc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new TinTucDA().getNumberProductDetail());
        return "tintuc";
    }

    @RequestMapping(value = "/xoatintuc")
    public String deletetintuc(int maQc, String tenQc, String anh, double gia, String nhaSanXuat, String mota, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        QuangCao qc = new QuangCao();
        qc.setMaQc(maQc);
        qc.setTenQc(tenQc);
        qc.setAnh(anh);
        qc.setGia(gia);
        qc.setNhaSanXuat(nhaSanXuat);
        qc.setMota(mota);
        qc.setTrangThai(false);
        new TinTucDA().delete(qc);
        TinTucDA da = new TinTucDA();
        List<QuangCao> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllqc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new TinTucDA().getNumberProductDetail());
        return "tintuc";

    }

    @RequestMapping(value = "/timtheotentintuc")
    public String searchTenTinTuc(String tenQc, Model model) {
        TinTucDA da = new TinTucDA();
        List<QuangCao> list = da.search(tenQc);
        model.addAttribute("getAllqc", list);
        return "tintuc";
    }

    @RequestMapping(value = "/chitiettintucs")
    public String detailtintuc(int maQc, Model model) {
        TinTucDA da = new TinTucDA();
        QuangCao qc = da.getById(maQc);
        model.addAttribute("qc", qc);
        return "chitiettintuc";
    }

    @RequestMapping(value = "/uploadanh")
    public ModelAndView upload(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.setContentType("text/plain");
        if (!(req instanceof MultipartHttpServletRequest)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Expected multipart request");
            return null;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
        MultipartFile file = multipartRequest.getFile("file");
        File destination = new File(req.getServletContext().getRealPath("images") + "\\" + file.getOriginalFilename());
        file.transferTo(destination);
        res.getWriter().write("http://localhost:8080/DoAnTotNghiepAdmin/images/" + file.getOriginalFilename());
        res.flushBuffer();
        return null;
    }

    //nhà cung cấp
    @RequestMapping(value = "/NhaCungCap")
    public String getAllNCC(Model model, Integer offset, Integer maxResult) {
        NhaCungCapDA da = new NhaCungCapDA();
        List<NhaCungCap> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllncc", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhaCungCapDA().getNumberProductDetail());
        return "nhacungcap";
    }

    @RequestMapping(value = "/taomoincc")
    public String createNhaCC(Model model, Integer offset, Integer maxResult) {
        NhaCungCap ncc = new NhaCungCap();
        model.addAttribute("nhacungcap", ncc);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhaCungCapDA().getNumberProductDetail());
        return "themnccap";
    }

    @RequestMapping(value = "luumoincc", method = RequestMethod.POST)
    public String saveNhaCC(String tenNcc, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setTenNcc(tenNcc);
        ncc.setTrangThai(trangThai);
        new NhaCungCapDA().insert(ncc);
        NhaCungCapDA da = new NhaCungCapDA();
        List<NhaCungCap> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllncc", data);
        return "nhacungcap";
    }

    @RequestMapping(value = "/updatencc")
    public String updatenhacc(int maNcc, Model model, Integer offset, Integer maxResult) {
        NhaCungCapDA da = new NhaCungCapDA();
        NhaCungCap ncc = da.getById(maNcc);
        model.addAttribute("nhacungcap", ncc);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new NhaCungCapDA().getNumberProductDetail());
        return "suanhacc";
    }

    @RequestMapping(value = "suancc", method = RequestMethod.POST)
    public String updatenhacungcap(int maNcc, String tenNcc, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNcc(maNcc);
        ncc.setTenNcc(tenNcc);
        ncc.setTrangThai(trangThai);
        new NhaCungCapDA().update(ncc);
        NhaCungCapDA da = new NhaCungCapDA();
        List<NhaCungCap> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllncc", data);
        return "nhacungcap";
    }

    @RequestMapping(value = "/xoanhacc")
    public String deletenhacungcap(int maNcc, String tenNcc, boolean trangThai, Model model, Integer offset, Integer maxResult) {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMaNcc(maNcc);
        ncc.setTenNcc(tenNcc);
        ncc.setTrangThai(false);
        new NhaCungCapDA().delete(ncc);
        NhaCungCapDA da = new NhaCungCapDA();
        List<NhaCungCap> data = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllncc", data);
        return "nhacungcap";

    }

    @RequestMapping(value = "/timtheotennhacungcap")
    public String searchTenNCC(String tenNcc, Model model) {
        NhaCungCapDA da = new NhaCungCapDA();
        List<NhaCungCap> list = da.search(tenNcc);
        model.addAttribute("getAllncc", list);
        return "nhacungcap";
    }

    @RequestMapping(value = "/chitietnhacc")
    public String detailNhaCC(int maNcc, Model model) {
        NhaCungCapDA da = new NhaCungCapDA();
        NhaCungCap ncc = da.getById(maNcc);
        model.addAttribute("ncc", ncc);
        return "chitietnhacungcap";
    }

    //khách hàng
    @RequestMapping(value = "/KhachHang")
    public String getAllKhachHang(Model model, Integer offset, Integer maxResult) {
        KhachHangDA khd = new KhachHangDA();
        List<KhachHang> data = khd.getProPage1(offset, maxResult);
        model.addAttribute("getAllkh", data);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new KhachHangDA().getNumberProductDetail());
        return "khachhang";
    }

    @RequestMapping(value = "/chitietkh")
    public String detailKhachHang(int maKh, Model model) {
        KhachHangDA khd = new KhachHangDA();
        KhachHang kh = khd.getById(maKh);
        model.addAttribute("kh", kh);
        return "chitietkhachhang";
    }

    @RequestMapping(value = "/timtenkhachhang")
    public String searchKhachHang(String tenKh, Model model) {
        KhachHangDA khd = new KhachHangDA();
        List<KhachHang> list = khd.search(tenKh);
        model.addAttribute("getAllkh", list);
        return "khachhang";
    }

    //Sản phẩm
    //Load sản phẩm
    @RequestMapping(value = "/SanPham")
    public String getSanPham(Model model, Integer offset, Integer maxResult) {
        SanPhamDA da = new SanPhamDA();
        List<SanPham> list = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllsp", list);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new SanPhamDA().getNumberProductDetail());
        return "sanpham";
    }

    //thêm mới sản phẩm
    @RequestMapping(value = "/taomoiSp")
    public String createSanPham(Model model, Integer offset, Integer maxResult) {
        SanPham sp = new SanPham();
        model.addAttribute("sanpham", sp);
        model.addAttribute("nsp", new NhomSanPhamDA().getProPage1(offset, maxResult));
        model.addAttribute("ncc", new NhaCungCapDA().getProPage1(offset, maxResult));
        return "themmoiSp";
    }

    @RequestMapping(value = "luumoisp", method = RequestMethod.POST)
    public String saveSanPham(String tenSp, String anh, double gia, String mota, boolean trangThai, int maNcc, int maNhomSp, Model model, Integer offset, Integer maxResult) {
        SanPham sp = new SanPham();
        sp.setTenSp(tenSp);
        sp.setAnh(anh);
        sp.setGia(gia);
        sp.setMota(mota);
        sp.setTrangThai(trangThai);
        NhaCungCap ncc = new NhaCungCap(maNcc);
        sp.setMaNcc(ncc);
        NhomSanPham nsp = new NhomSanPham(maNhomSp);
        sp.setMaNhomSp(nsp);
        new SanPhamDA().insert(sp);

        SanPhamDA da = new SanPhamDA();
        List<SanPham> list = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllsp", list);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new SanPhamDA().getNumberProductDetail());
        return "sanpham";
    }

    //load ảnh sản phẩm
    @RequestMapping(value = "/uploadanhsp")
    public ModelAndView uploadanhsanpham(HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.setContentType("text/plain");
        if (!(req instanceof MultipartHttpServletRequest)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Expected multipart request");
            return null;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
        MultipartFile file = multipartRequest.getFile("file");
        File destination = new File(req.getServletContext().getRealPath("images") + "\\" + file.getOriginalFilename());
        file.transferTo(destination);
        res.getWriter().write("http://localhost:8080/DoAnTotNghiepAdmin/images/" + file.getOriginalFilename());
        res.flushBuffer();
        return null;
    }

    //update sản phẩm
    @RequestMapping(value = "/updatesp")
    public String updateSanPham(int maSp, Model model, Integer offset, Integer maxResult) {
        SanPhamDA spd = new SanPhamDA();
        SanPham sp = spd.getById(maSp);
        model.addAttribute("sanpham", sp);
        model.addAttribute("nsp", new NhomSanPhamDA().getProPage1(offset, maxResult));
        model.addAttribute("ncc", new NhaCungCapDA().getProPage1(offset, maxResult));
        return "suaSanpham";
    }

    @RequestMapping(value = "suasp", method = RequestMethod.POST)
    public String SuaSanPham(int maSp, String tenSp, String anh, double gia, String mota, boolean trangThai, int maNcc, int maNhomSp, Model model, Integer offset, Integer maxResult) {
        SanPham sp = new SanPham();
        sp.setMaSp(maSp);
        sp.setTenSp(tenSp);
        sp.setAnh(anh);
        sp.setGia(gia);
        sp.setMota(mota);
        sp.setTrangThai(trangThai);
        NhaCungCap ncc = new NhaCungCap(maNcc);
        sp.setMaNcc(ncc);
        NhomSanPham nsp = new NhomSanPham(maNhomSp);
        sp.setMaNhomSp(nsp);
        new SanPhamDA().update(sp);
        SanPhamDA da = new SanPhamDA();
        List<SanPham> list = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllsp", list);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new SanPhamDA().getNumberProductDetail());
        return "sanpham";
    }

    //Xóa sản phẩm
    @RequestMapping(value = "/xoasanpham")
    public String deleteSanPham(int maSp, String tenSp, String anh, Double gia, String moTa, Model model, Integer offset, int maNcc, int maNhomSp, Integer maxResult) {
        SanPhamDA spd = new SanPhamDA();
        SanPham sp = new SanPham();
        sp.setMaSp(maSp);
        sp.setTenSp(tenSp);
        sp.setAnh(anh);
        sp.setGia(gia);
        sp.setMota(moTa);
        sp.setTrangThai(false);
        NhaCungCap ncc = new NhaCungCap(maNcc);
        sp.setMaNcc(ncc);
        NhomSanPham nsp = new NhomSanPham(maNhomSp);
        sp.setMaNhomSp(nsp);

        new SanPhamDA().delete(sp);

        List<SanPham> list = spd.getProPage1(offset, maxResult);
        model.addAttribute("getAllsp", list);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new SanPhamDA().getNumberProductDetail());
        return "sanpham";

    }

    //chi tiết sản phẩm
    @RequestMapping(value = "/chitietsp")
    public String detailSanPham(int maSp, Model model) {
        SanPhamDA spd = new SanPhamDA();
        SanPham sp = spd.getById(maSp);
        model.addAttribute("sp", sp);
        return "chitietsanpham";
    }

    //tìm kiếm theo tên sản phẩm
    @RequestMapping(value = "/timtensanpham")
    public String searchSanPham(String tenSp, Model model) {
        SanPhamDA spd = new SanPhamDA();
        List<SanPham> list = spd.search(tenSp);
        model.addAttribute("getAllsp", list);
        return "sanpham";
    }

    //Hóa đơn
    @RequestMapping(value = "/HoaDon")
    public String getHoaDon(Model model, Integer offset, Integer maxResult) {
        DonHangDA da = new DonHangDA();
        List<DonHang> list = da.getProPage1(offset, maxResult);
        model.addAttribute("getAllhd", list);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new DonHangDA().getNumberProductDetail());
        return "hoadon";
    }

    //tìm kiếm theo tên hóa đơn
    @RequestMapping(value = "/timhoadon")
    public String searchDonHabg(String tenKh, Model model) {
        DonHangDA da = new DonHangDA();
        List<DonHang> list = da.search(tenKh);
        model.addAttribute("getAllhd", list);
        return "hoadon";
    }

    //Chi tiết hóa đơn
    @RequestMapping(value = "/ChiTietHoaDon")
    public String getDonHang(Model model, Integer offset, Integer maxResult) {
        ChiTietDonHangDA ctdh = new ChiTietDonHangDA();
        List<ChiTietDonHang> list = ctdh.getProPage1(offset, maxResult);
        model.addAttribute("getAlldh", list);
        model.addAttribute("offset", offset);
        model.addAttribute("numberProductDetail", new ChiTietDonHangDA().getNumberProductDetail());
        return "chitietdonhang";
    }

    //đăng ký
    @RequestMapping(value = "/Dangky")
    public String getDangKy(Model model) {
        QuangTriDA qtd = new QuangTriDA();
        List<QuanTri> list = qtd.getAll();
        model.addAttribute("getAllqt", list);
        return "dangky";
    }

    //THÊM MỚI ĐĂNG KÝ
    @RequestMapping(value = "/taomoiquantri")
    public String createQuanTri(Model model) {
        QuanTri qt = new QuanTri();
        model.addAttribute("quantri", qt);
        return "themquantri";
    }

    @RequestMapping(value = "luumoiquantri", method = RequestMethod.POST)
    public String saveQuanTri(String tenQt, String taiKhoan, String matKhau, boolean trangThai, Model model) {

        QuanTri qt = new QuanTri();
        qt.setTenQt(tenQt);
        qt.setMatKhau(matKhau);
        qt.setTaiKhoan(taiKhoan);
        qt.setTrangThai(trangThai);
        new QuangTriDA().insert(qt);
        QuangTriDA da = new QuangTriDA();
        List<QuanTri> data = da.getAll();
        model.addAttribute("getAllqt", data);
        return "dangky";
    }
//cập nhật đăng ký

    @RequestMapping(value = "/updatequantri")
    public String updateQuanTri(int maQt, Model model) {
        QuangTriDA da = new QuangTriDA();
        QuanTri qt = da.getById(maQt);
        model.addAttribute("quantri", qt);
        return "suaquantri";
    }

    @RequestMapping(value = "suaquantri", method = RequestMethod.POST)
    public String updateQuanTri(int maQt, String tenQt, String taiKhoan, String matKhau, boolean trangThai, Model model) {
        QuanTri qt = new QuanTri();
        qt.setMaQt(maQt);
        qt.setTenQt(tenQt);
        qt.setMatKhau(matKhau);
        qt.setTaiKhoan(taiKhoan);
        qt.setTrangThai(trangThai);
        new QuangTriDA().update(qt);
        QuangTriDA da = new QuangTriDA();
        List<QuanTri> data = da.getAll();
        model.addAttribute("getAllqt", data);
        return "dangky";
    }

    //xóa đăng ký
    @RequestMapping(value = "/xoaquantri")
    public String deleteQuanTri(int id, Model model) {
        QuangTriDA da = new QuangTriDA();
        da.delete(id);
        List<QuanTri> data = da.getAll();
        model.addAttribute("getAllqt", data);
        return "dangky";

    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";

    }

    @RequestMapping(value = "/DangNhap")
    public String getDangNhap(Integer offset, Integer maxResult, ModelMap mm, HttpServletRequest request, QuanTri qt, Model model, String taiKhoan, String matKhau) {
        QuangTriDA qtd = new QuangTriDA();
        QuanTri qts = qtd.loginQuanTri(qt.getTaiKhoan(), qt.getMatKhau());
        if (qts != null) {
            HttpSession session = request.getSession();
            session.setAttribute("name", qts.getTenQt());
            NhomSanPhamDA da = new NhomSanPhamDA();
            List<NhomSanPham> listdm = da.getProPage1(offset, maxResult);
            model.addAttribute("getAllnsp", listdm);
            model.addAttribute("offset", offset);
            model.addAttribute("numberProductDetail", new NhomSanPhamDA().getNumberProductDetail());
            mm.put("msgSussess", "Ban da dang nhap thanh cong");
            return "home";
        } else {
            mm.put("msgError", "Tai khoan hoac mat khau khong dung");
            return "login";

        }
    }

    @RequestMapping(value = "/dangxuat")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";

    }

}
