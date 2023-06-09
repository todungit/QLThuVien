USE [QLTV]
GO
/****** Object:  Table [dbo].[CT_PhieuMuonSach]    Script Date: 15/05/2022 21:52:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_PhieuMuonSach](
	[MaPhieuMuonSach] [int] NOT NULL,
	[NgayMuon] [date] NULL,
	[ThoiGianMuon] [nvarchar](10) NULL,
	[TienCoc] [float] NULL,
	[SoLuongMuon] [int] NULL,
	[MaSach] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuMuonSach] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_PhieuTraSach]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_PhieuTraSach](
	[MaPhieuTraSach] [int] NOT NULL,
	[NgayTra] [date] NULL,
	[TinhTrang] [nvarchar](20) NULL,
	[TienPhat] [float] NULL,
	[SoLuongTra] [int] NULL,
	[MaSach] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuTraSach] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DocGia]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DocGia](
	[MaDocGia] [int] IDENTITY(1,1) NOT NULL,
	[TenĐocGia] [nvarchar](20) NULL,
	[NamSinh] [date] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDocGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSach]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSach](
	[MaLoaiSach] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiSach] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](20) NULL,
	[NamSinh] [date] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuMuonSach]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuMuonSach](
	[MaPhieuMuonSach] [int] IDENTITY(1,1) NOT NULL,
	[MaDocGia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuMuonSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuTraSach]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuTraSach](
	[MaPhieuTraSach] [int] IDENTITY(1,1) NOT NULL,
	[MaDocGia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuTraSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [int] IDENTITY(1,1) NOT NULL,
	[TenSach] [nvarchar](20) NULL,
	[TenDocGia] [nvarchar](20) NULL,
	[TenNhaXuatBan] [nvarchar](20) NULL,
	[NamXuatBan] [int] NULL,
	[SoTrang] [int] NULL,
	[SoLuongSach] [int] NULL,
	[MaLoaiSach] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 15/05/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTaiKhoan] [int] IDENTITY(1,1) NOT NULL,
	[TenDangNhap] [varchar](20) NULL,
	[MatKhau] [varchar](20) NULL,
	[Quyen] [nvarchar](10) NULL,
	[MaNhanVien] [int] NULL,
	[MaDocGia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[TaiKhoan] ADD  DEFAULT (N'Độc Giả') FOR [Quyen]
GO
ALTER TABLE [dbo].[PhieuMuonSach]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuonSach_ĐocGia] FOREIGN KEY([MaDocGia])
REFERENCES [dbo].[DocGia] ([MaDocGia])
GO
ALTER TABLE [dbo].[PhieuMuonSach] CHECK CONSTRAINT [FK_PhieuMuonSach_ĐocGia]
GO
ALTER TABLE [dbo].[PhieuTraSach]  WITH CHECK ADD  CONSTRAINT [FK_PhieuTraSach_DocGia] FOREIGN KEY([MaDocGia])
REFERENCES [dbo].[DocGia] ([MaDocGia])
GO
ALTER TABLE [dbo].[PhieuTraSach] CHECK CONSTRAINT [FK_PhieuTraSach_DocGia]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_LoaiSach] FOREIGN KEY([MaLoaiSach])
REFERENCES [dbo].[LoaiSach] ([MaLoaiSach])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_LoaiSach]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_DocGia] FOREIGN KEY([MaDocGia])
REFERENCES [dbo].[DocGia] ([MaDocGia])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_DocGia]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[CT_PhieuMuonSach]  WITH CHECK ADD CHECK  (([SoLuongMuon]>=(0)))
GO
ALTER TABLE [dbo].[CT_PhieuTraSach]  WITH CHECK ADD CHECK  (([SoLuongTra]>=(0)))
GO
ALTER TABLE [dbo].[DocGia]  WITH CHECK ADD CHECK  (([SDT]>(99999999) AND [SDT]<(999999999)))
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD CHECK  (([SDT]>(99999999) AND [SDT]<(999999999)))
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD CHECK  (([NamXuatBan]>(1900) AND [NamXuatBan]<(2023)))
GO
