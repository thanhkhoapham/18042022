USE [KhoaLuan_v2]
GO
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([id], [ten_role]) VALUES (1, N'ADMIN')
INSERT [dbo].[role] ([id], [ten_role]) VALUES (2, N'USER')
SET IDENTITY_INSERT [dbo].[role] OFF
SET IDENTITY_INSERT [dbo].[nguoi_dung] ON 

INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (2, N'17 nguyễn thái sơn, phường 3, gò vấp, tphcm', N'lucgiaanh1707@gmail.com', 1, N'$2a$10$leD9sXBWGmM7MtQqoIoO6.4na3HEEG2nFBMzMMWzdpNKxguEw2xz.', N'0111444777', N'Gia Anh', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (3, N'tphcm', N'thanhkhoapham03@gmail.com', 1, N'$2a$10$GF5Mo28ajO2fCSPzOuQ03.3Eo7wz2fqbcQyddFhLMWKvA43moFB2G', N'0123456789', N'Thành Khoa', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (4, N'22 nguyễn thái sơn, phường 3, gò vấp, tphcm', N'sdsdsds07@gmail.com', 1, N'$2a$10$leD9sXBWGmM7MtQqoIoO6.4na3HEEG2nFBMzMMWzdpNKxguEw2xz.', N'0111444777', N'Ngô Mai Linh', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (5, N'Thủ ĐỨc', N'ahanhkhoapham03@gmail.com', 1, N'$2a$10$GF5Mo28ajO2fCSPzOuQ03.3Eo7wz2fqbcQyddFhLMWKvA43moFB2G', N'0123456789', N'Đức Huy', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (6, N'17 Quang Trung, phường 3, gò vấp, tphcm', N'qqqqqq1707@gmail.com', 1, N'$2a$10$leD9sXBWGmM7MtQqoIoO6.4na3HEEG2nFBMzMMWzdpNKxguEw2xz.', N'0111444777', N'Minh Tân', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (7, N'BẾn Tre', N'iiiii@gmail.com', 1, N'$2a$10$GF5Mo28ajO2fCSPzOuQ03.3Eo7wz2fqbcQyddFhLMWKvA43moFB2G', N'0123456789', N'Minh TUấn', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (8, N'17 Huỳnh Khương An, phường 4, gò vấp, tphcm', N'lsdddđ1707@gmail.com', 1, N'$2a$10$leD9sXBWGmM7MtQqoIoO6.4na3HEEG2nFBMzMMWzdpNKxguEw2xz.', N'0111444777', N'Leader Thuận', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (9, N'American', N'aaaaaaa@gmail.com', 1, N'$2a$10$GF5Mo28ajO2fCSPzOuQ03.3Eo7wz2fqbcQyddFhLMWKvA43moFB2G', N'0123456789', N'PM Quân', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (10, N'Phú Quốc', N'lucgiaanh1707@gmail.com', 1, N'$2a$10$leD9sXBWGmM7MtQqoIoO6.4na3HEEG2nFBMzMMWzdpNKxguEw2xz.', N'0111444777', N'Chú Lệ', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (11, N'Mũi Né', N'th@gmail.com', 1, N'$2a$10$GF5Mo28ajO2fCSPzOuQ03.3Eo7wz2fqbcQyddFhLMWKvA43moFB2G', N'0123456789', N'Spy', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (12, N'Hậu Giang', N'zzzznh1707@gmail.com', 1, N'$2a$10$leD9sXBWGmM7MtQqoIoO6.4na3HEEG2nFBMzMMWzdpNKxguEw2xz.', N'0111444777', N'Sa Sa', NULL, 2)
INSERT [dbo].[nguoi_dung] ([id], [dia_chi], [email], [enable], [mat_khau], [so_dien_thoai], [ten_nguoi_dung], [verification_code], [role_id]) VALUES (13, N'Sa Pa', N'hhhhh@gmail.com', 1, N'$2a$10$GF5Mo28ajO2fCSPzOuQ03.3Eo7wz2fqbcQyddFhLMWKvA43moFB2G', N'0123456789', N'Idol Tiktoc', NULL, 2)
SET IDENTITY_INSERT [dbo].[nguoi_dung] OFF
SET IDENTITY_INSERT [dbo].[san_pham] ON 

INSERT [dbo].[san_pham] ([loai_sanpham], [id], [enable], [gia], [mo_ta], [ten_san_pham], [url_hinh_anh], [bo_nho_dem], [cong_nghecpu], [loaicpu], [so_nhan], [card_do_hoa], [cpu], [he_dieu_hanh], [man_hinh], [o_cung], [ram], [trong_luong], [hangsx_id], [nhacungcap_id]) VALUES (N'laptop', 1, 1, 999999, N'just a laptop?', N'Laptop 1', N'https://cdn.nguyenkimmall.com/images/detailed/775/10050940-laptop-dell-latitude-3420-i5-1135g7-l3420i5ssd-1.jpg', NULL, NULL, NULL, NULL, N'rtx', NULL, N'win 11', NULL, NULL, 8, 1.8, NULL, NULL)
INSERT [dbo].[san_pham] ([loai_sanpham], [id], [enable], [gia], [mo_ta], [ten_san_pham], [url_hinh_anh], [bo_nho_dem], [cong_nghecpu], [loaicpu], [so_nhan], [card_do_hoa], [cpu], [he_dieu_hanh], [man_hinh], [o_cung], [ram], [trong_luong], [hangsx_id], [nhacungcap_id]) VALUES (N'laptop', 2, 1, 1234567, N'just a laptop but no2?', N'Laptop 2', N'https://cdn.tgdd.vn/Products/Images/44/268712/dell-xps-17-9710-i7-xps7i7001w1-1-600x600.jpg', NULL, NULL, NULL, NULL, N'rtx', NULL, N'win 10', NULL, NULL, 16, 0, NULL, NULL)
INSERT [dbo].[san_pham] ([loai_sanpham], [id], [enable], [gia], [mo_ta], [ten_san_pham], [url_hinh_anh], [bo_nho_dem], [cong_nghecpu], [loaicpu], [so_nhan], [card_do_hoa], [cpu], [he_dieu_hanh], [man_hinh], [o_cung], [ram], [trong_luong], [hangsx_id], [nhacungcap_id]) VALUES (N'cpu', 3, 1, 55555, N'cpu', N'CPU 1', N'https://media.bkns.vn/uploads/2020/02/cpu-la-gi.jpg', 128, NULL, NULL, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[san_pham] OFF
