Create database Shopping
go


use Shopping

create table NhaCungCap(
	MaNcc int identity primary key,
	TenNcc nvarchar(50),
	TrangThai bit)

insert into NhaCungCap values(N'Kim đồng',1)
insert into NhaCungCap values(N'Xã việt',1)
insert into NhaCungCap values(N'Hòa binh',1)

create table QuanTri(
	MaQt int identity primary key,
	TenQt nvarchar(100),
	TaiKhoan nvarchar(100),
	MatKhau nvarchar(100),
	TrangThai bit)

create table KhachHang(
	MaKh int identity primary key,
	TenKh nvarchar(100),
	TenTk nvarchar(50),
	MatKhau nvarchar(50),
	DiaChi nvarchar(100),
	SoDienThoai int,
	Email nvarchar(100),
	TrangThai bit)

create table NhomSanPham(
	MaNhomSp int identity primary key,
	TenNhomSp nvarchar(100),
	TrangThai bit)


insert into NhomSanPham values ('Ao Hodie',1)
insert into NhomSanPham values ('Quan Jogger',1)
insert into NhomSanPham values ('Quan Jean',1)

create table SanPham(
	MaSp int identity primary key,
	TenSp nvarchar(100),
	Anh nvarchar(max),
	Gia float,
	MaNcc int foreign key references NhaCungCap(MaNcc),
	Mota nvarchar(max),
	TrangThai bit,
	MaNhomSp int foreign key references NhomSanPham(MaNhomSp))
	
insert into SanPham values('Áo Alpha','https://salt.tikicdn.com/cache/550x550/ts/product/6a/bf/2a/a0c6797797b8708e78fc3d9521dc669b.jpg',1000000,1,'...',1,1)
insert into SanPham values('Hodie Curen','http://media3.scdn.vn/img2/2018/1_17/SGuIt9_simg_d0daf0_800x1200_max.jpg',1000000,1,'...',1,1)
insert into SanPham values('Hodie Anti','https://sakurafashion.vn/upload/sanpham/large/5078-ao-hoodie-ghep-hai-manh-1.jpg',1000000,1,'...',1,1)

insert into SanPham values('Jogger Alpha','https://cdn3.yame.vn/pimg/quan-jogger-nam-ma-bu-thun-s02-0016716/3b8e3d73-481d-b100-846d-0014baa95f27.jpg?w=800&c=true&ntf=false',1000000,1,'...',1,2)
insert into SanPham values('Jogger Curen','https://cdn3.yame.vn/pimg/quan-jogger-nam-ma-bu-thun-s01-0016715/8b1d2463-8ed0-2900-89aa-0014c5bfd83f.jpg?w=540&h=756&c=true&ntf=false',1000000,1,'...',1,2)
insert into SanPham values('Jogger Anti','https://cdn2.yame.vn/pimg/quan-jogger-nam-ma-bu-thun-st02-0017875/74b191e9-9f64-bf00-d090-001523fbd1a5.jpg?w=540&h=756&c=true&ntf=false',1000000,1,'...',1,2)

insert into SanPham values('Jean Apache','https://ragus.vn/wp-content/uploads/2019/01/Qu%E1%BA%A7n-Jeans-Nam-Slim-Cropp-R%C3%A1ch-routine-QJ225007-2.jpg',1000000,2,'...',1,3)
insert into SanPham values('Jean Curen','https://ragus.vn/wp-content/uploads/2019/01/Qu%E1%BA%A7n-Jeans-Nam-Slim-Cropp-R%C3%A1ch-routine-QJ225007-2.jpg',1000000,3,'...',1,3)
insert into SanPham values('Jean Anti','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbvAYTapB7bpNirFV7f1nzkesENnmLwUH31WGTKlGkViF0dsbHyg',1000000,1,'...',1,3)

create table DanhGia(
	MaYt int identity primary key,
	SoSao int,
	MaSp int foreign key references SanPham(MaSp),
	MaKh int foreign key references KhachHang(MaKh))


create table UaThich(
	MaUt int identity primary key,
	MaKh int foreign key references KhachHang(MaKh),
	MaSp int foreign key references SanPham(MaSp))


create table QuangCao(
	MaQc int identity primary key,
	TenQc nvarchar(100),
	Anh nvarchar(max),
	Gia float,
	NhaSanXuat nvarchar(100),
	Mota nvarchar(max),
	TrangThai bit)

insert into QuangCao values('Hodie Alpha','http://cdn.nhanh.vn/cdn/store/23832/art/article_1526185666_428.jpg',1000000,'VietNamMade','...',1)
insert into QuangCao values('Hodie Alpha','https://ragus.vn/wp-content/uploads/2018/10/quan-tay-thun-nam-routine-2.jpg',1000000,'VietNamMade','...',1)


Create table ThanhToan(
	MaTt int identity primary key,
	TenTt nvarchar(100),
	Mota nvarchar(max),
	TrangThai bit)

insert into ThanhToan values(N'Thanh toán bằng thẻ tín dụng', N'Bạn có thể trả phí trực tiếp thông qua số tài khoản ATM',1)
insert into ThanhToan values(N'Thanh toán trực tiếp', N'Bạn có thể trả phí khi nhận được hàng',1)

Create table VanChuyen(
	MaVc int identity primary key,
	TenVc nvarchar(100),
	Gia float,
	Mota nvarchar(max),
	TrangThai bit)

insert into VanCHuyen values(N'Viettel port',30000, N'Giao Hàng từ 5 - 10 ngày',1)
insert into VanCHuyen values(N'Speed Method',50000, N'Giao Hàng từ 3 - 5 ngày',1)
insert into VanCHuyen values(N'Go Viet',70000, N'Giao Hàng từ 1 - 3 ngày',1)

Create table DonHang(
	MaDh int identity primary key,
	TenKh nvarchar(100),
	Email nvarchar(50),
	DiaChi nvarchar(100),
	SoDienThoai nvarchar(50),
	TongTien float,
	NgayMua nvarchar(50),
	TrangThai bit,
	MaKh int foreign key references KhachHang(MaKh),
	MaTt int foreign key references ThanhToan(MaTt),
	MaVc int foreign key references VanCHuyen(MaVc))

Create table ChiTietDonHang(
	MaChiTietDh int identity primary key,
	MaDh int foreign key references DonHang(MaDh),
	MaSp int foreign key references SanPham(MaSp),
	SoLuong int,
	GiaTien float,
	TrangThai bit)


