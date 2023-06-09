CREATE
DATABASE MonShop

USE MonShop
GO
USE MASTER
/****** Object:  Table [dbo].[Account]    Script Date: 3/15/2023 8:50:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account]
(
    [
    email] [
    varchar]
(
    255
) NOT NULL,
    [password] [varchar]
(
    255
) NOT NULL,
    [image] [varchar]
(
    1000
) NULL,
    [fullname] [nvarchar]
(
    255
) NULL,
    [address] [nvarchar]
(
    255
) NULL,
    [phone_number] [varchar]
(
    20
) NULL,
    [is_deleted] [bit] NULL,
    [role_id] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[
    email] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Categories]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[Categories]
(
    [
    category_id] [
    int]
    NOT
    NULL, [
    category_name] [
    nvarchar]
(
    255
) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[
    category_id] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[OrderItem]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[OrderItem]
(
    [
    order_item_id] [
    int]
    IDENTITY
(
    1,
    1
) NOT NULL,
    [order_id] [int] NOT NULL,
    [sku] [varchar]
(
    5
) NOT NULL,
    [quantity] [int] NOT NULL,
    [price] [float] NULL,
    [subtotal] [float] NULL,
    PRIMARY KEY CLUSTERED
(
[
    order_item_id] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Orders]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[Orders]
(
    [
    order_id] [
    int]
    IDENTITY
(
    1,
    1
) NOT NULL,
    [email] [varchar]
(
    255
) NULL,
    [order_date] [varchar]
(
    10
) NULL,
    [total] [float] NULL,
    [order_status_id] [int] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[
    order_id] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[OrderStatuses]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[OrderStatuses]
(
    [
    order_status_id] [
    int]
    NOT
    NULL, [
    order_status] [
    varchar]
(
    255
) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[
    order_status_id] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Products]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[Products]
(
    [
    sku] [
    varchar]
(
    5
) NOT NULL,
    [product_name] [nvarchar]
(
    255
) NOT NULL,
    [image] [varchar]
(
    255
) NOT NULL,
    [price] [float] NOT NULL,
    [quantity] [int] NOT NULL,
    [description] [text] NULL,
    [category_id] [int] NULL,
    [product_status_id] [int] NULL,
    [is_deleted] [bit] NULL,
    PRIMARY KEY CLUSTERED
(
[
    sku] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[ProductStatuses]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[ProductStatuses]
(
    [
    product_status_id] [
    int]
    NOT
    NULL, [
    product_status] [
    varchar]
(
    50
) NULL,
    PRIMARY KEY CLUSTERED
(
[
    product_status_id] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[Roles]    Script Date: 3/15/2023 8:50:09 AM ******/
    SET ANSI_NULLS
    ON
    GO
    SET QUOTED_IDENTIFIER
    ON
    GO
CREATE TABLE [dbo].[Roles]
(
    [
    role_id] [
    int]
    NOT
    NULL, [
    role_name] [
    varchar]
(
    255
) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[
    role_id] ASC
)
    WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF)
    ON [PRIMARY]
    )
    ON [PRIMARY]
    GO
    INSERT [dbo].[Account]
(
    [
    email], [
    password], [
    image], [
    fullname], [
    address], [
    phone_number], [
    is_deleted],
[
    role_id]
) VALUES
(
    N'duonghongquan0312@gmail.com',
    N'03122002',
    N'https://scontent.fsgn5-6.fna.fbcdn.net/v/t39.30808-6/305401618_112341014941746_7229606053298462997_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=nl2JmISRQIQAX_BlZQ6&_nc_ht=scontent.fsgn5-6.fna&oh=00_AfCCJFIXd6zKhoSLteUx7ectAhHgZpDI6Yq6HYz2O4dA0Q&oe=640AA20A',
    N'Duong Hong Quan',
    N'Da lat',
    N'0366967957',
    0,
    1
)
    INSERT [dbo].[Account]
(
    [
    email], [
    password], [
    image], [
    fullname], [
    address], [
    phone_number], [
    is_deleted],
[
    role_id]
) VALUES
(
    N'lemyngoc@gmail.com',
    N'09102002',
    N'https://scontent.fsgn5-6.fna.fbcdn.net/v/t39.30808-6/310038396_123571710485343_8469787686293420920_n.jpg?stp=cp6_dst-jpg&_nc_cat=108&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=ru9bQgACtPcAX_YRlUN&_nc_ht=scontent.fsgn5-6.fna&oh=00_AfBq-_jcyEKaVefBpx9DKU_KX8aGLepOKYP_iWh5nHKcGw&oe=640A13E5',
    N'Le Thi My Ngoc',
    N'Tuy Hoa',
    N'0900 000 0000',
    0,
    2
)
    INSERT [dbo].[Account]
(
    [
    email], [
    password], [
    image], [
    fullname], [
    address], [
    phone_number], [
    is_deleted],
[
    role_id]
) VALUES
(
    N'nguyenthanhhoa@gmail.com',
    N'hoa123',
    N'https://randomuser.me/api/portraits/women/42.jpg',
    N'Nguyen Thanh Hoa',
    N'Hanoi',
    N'0987654321',
    0,
    2
)
    INSERT [dbo].[Account]
(
    [
    email], [
    password], [
    image], [
    fullname], [
    address], [
    phone_number], [
    is_deleted],
[
    role_id]
) VALUES
(
    N'tranquanghuy@gmail.com',
    N'huy123',
    N'https://randomuser.me/api/portraits/men/18.jpg',
    N'Tran Quang Huy',
    N'Hanoi',
    N'0123456789',
    0,
    2
)
    GO
    INSERT [dbo].[Categories]
(
    [
    category_id],
[
    category_name]
) VALUES
(
    1,
    N'T-Shirt'
)
    INSERT [dbo].[Categories]
(
    [
    category_id],
[
    category_name]
) VALUES
(
    2,
    N'Hoodie'
)
    INSERT [dbo].[Categories]
(
    [
    category_id],
[
    category_name]
) VALUES
(
    3,
    N'Pant'
)
    INSERT [dbo].[Categories]
(
    [
    category_id],
[
    category_name]
) VALUES
(
    4,
    N'Bag'
)
    GO
    SET IDENTITY_INSERT [dbo].[OrderItem]
    ON
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    1,
    1,
    N'P0010',
    1,
    17,
    17
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    2,
    1,
    N'P0008',
    1,
    31,
    31
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    3,
    1,
    N'P0001',
    1,
    35,
    35
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    4,
    1,
    N'P0003',
    1,
    22,
    22
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    5,
    1,
    N'P0002',
    2,
    20,
    40
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    6,
    2,
    N'P0010',
    1,
    17,
    17
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    7,
    2,
    N'P0008',
    1,
    31,
    31
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    8,
    2,
    N'P0001',
    1,
    35,
    35
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    9,
    2,
    N'P0003',
    1,
    22,
    22
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    10,
    2,
    N'P0002',
    2,
    20,
    40
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    11,
    3,
    N'P0010',
    1,
    17,
    17
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    12,
    3,
    N'P0008',
    1,
    31,
    31
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    13,
    3,
    N'P0001',
    1,
    35,
    35
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    14,
    3,
    N'P0003',
    1,
    22,
    22
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    15,
    3,
    N'P0002',
    2,
    20,
    40
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    16,
    4,
    N'P0010',
    1,
    17,
    17
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    17,
    4,
    N'P0008',
    1,
    31,
    31
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    18,
    4,
    N'P0001',
    1,
    35,
    35
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    19,
    4,
    N'P0003',
    1,
    22,
    22
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    20,
    4,
    N'P0002',
    2,
    20,
    40
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    21,
    5,
    N'P0005',
    2,
    30,
    60
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    22,
    5,
    N'P0004',
    3,
    25,
    75
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    23,
    5,
    N'P0006',
    2,
    32,
    64
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    24,
    5,
    N'P0001',
    1,
    35,
    35
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    25,
    5,
    N'P0003',
    2,
    22,
    44
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    26,
    5,
    N'P0002',
    2,
    20,
    40
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    27,
    6,
    N'P0005',
    4,
    30,
    120
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    28,
    7,
    N'P0001',
    1,
    35,
    35
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    29,
    7,
    N'P0003',
    2,
    22,
    44
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    30,
    7,
    N'P0002',
    2,
    20,
    40
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    31,
    8,
    N'P0008',
    1,
    31,
    31
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    32,
    8,
    N'P0005',
    1,
    30,
    30
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    33,
    8,
    N'P0014',
    1,
    22,
    22
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    34,
    9,
    N'P0009',
    1,
    12,
    12
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    35,
    9,
    N'P0003',
    3,
    22,
    66
)
    INSERT [dbo].[OrderItem]
(
    [
    order_item_id], [
    order_id], [
    sku], [
    quantity], [
    price],
[
    subtotal]
) VALUES
(
    36,
    9,
    N'P0002',
    1,
    20,
    20
)
    SET IDENTITY_INSERT [dbo].[OrderItem] OFF
    GO
    SET IDENTITY_INSERT [dbo].[Orders]
    ON
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    1,
    N'duonghongquan0312@gmail.com',
    N'10/03/2023',
    145,
    3
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    2,
    N'lemyngoc@gmail.com',
    N'01/03/2023',
    145,
    3
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    3,
    N'nguyenthanhhoa@gmail.com',
    N'02/03/2023',
    145,
    3
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    4,
    N'tranquanghuy@gmail.com',
    N'10/03/2023',
    145,
    3
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    5,
    N'lemyngoc@gmail.com',
    N'12/03/2023',
    318,
    1
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    6,
    N'lemyngoc@gmail.com',
    N'12/03/2023',
    120,
    1
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    7,
    N'nguyenthanhhoa@gmail.com',
    N'14/03/2023',
    119,
    2
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    8,
    N'nguyenthanhhoa@gmail.com',
    N'15/03/2023',
    83,
    1
)
    INSERT [dbo].[Orders]
(
    [
    order_id], [
    email], [
    order_date], [
    total],
[
    order_status_id]
) VALUES
(
    9,
    N'tranquanghuy@gmail.com',
    N'14/03/2023',
    98,
    2
)
    SET IDENTITY_INSERT [dbo].[Orders] OFF
    GO
    INSERT [dbo].[OrderStatuses]
(
    [
    order_status_id],
[
    order_status]
) VALUES
(
    1,
    N'Pending'
)
    INSERT [dbo].[OrderStatuses]
(
    [
    order_status_id],
[
    order_status]
) VALUES
(
    2,
    N'In Progress'
)
    INSERT [dbo].[OrderStatuses]
(
    [
    order_status_id],
[
    order_status]
) VALUES
(
    3,
    N'Completed'
)
    GO
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0001',
    N'BASIC MOOD TEE',
    N'https://product.hstatic.net/200000195489/product/green_notext_d78dcbd3562349b0940a4ca38e0cd723_grande.jpg',
    35,
    97,
    N'This product is made of high-quality Corduroy fabric with a density of 350gsm, which provides a thick and durable texture that limits shedding. Its outer surface is soft and smooth, while the inner surface is breathable, making it suitable for all weather conditions. Additionally, the discreetly sewn pockets on the sides and hidden message printed in each color variation around the collar add a touch of uniqueness and style to the product. With a wide range of color combinations to choose from, this product is a great addition to any wardrobe.',
    1,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0002',
    N'BEARMOJI TEE MST',
    N'https://product.hstatic.net/200000195489/product/bearmoji_kem_654bf17d186049c597cd0bd893f0434b_grande.jpg',
    20,
    193,
    N'This product is made of high-quality Corduroy fabric with a density of 350gsm, which provides a thick and durable texture that limits shedding. Its outer surface is soft and smooth, while the inner surface is breathable, making it suitable for all weather conditions. Additionally, the discreetly sewn pockets on the sides and hidden message printed in each color variation around the collar add a touch of uniqueness and style to the product. With a wide range of color combinations to choose from, this product is a great addition to any wardrobe.',
    1,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0003',
    N'BLING TEE MST',
    N'https://product.hstatic.net/200000195489/product/coban_ko_text_1b839fe39f544249bb468eac671c1269_grande.jpg',
    22,
    292,
    N'This product is made of high-quality Corduroy fabric with a density of 350gsm, which provides a thick and durable texture that limits shedding. Its outer surface is soft and smooth, while the inner surface is breathable, making it suitable for all weather conditions. Additionally, the discreetly sewn pockets on the sides and hidden message printed in each color variation around the collar add a touch of uniqueness and style to the product. With a wide range of color combinations to choose from, this product is a great addition to any wardrobe.',
    1,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0004',
    N'DAISY FLOWER TEE MISSOUT',
    N'https://product.hstatic.net/200000195489/product/daisy_tee_truoc_61b3c245f0bc4f9aaacf0cf8e94dc209_grande.png',
    25,
    397,
    N'This product is made of high-quality Corduroy fabric with a density of 350gsm, which provides a thick and durable texture that limits shedding. Its outer surface is soft and smooth, while the inner surface is breathable, making it suitable for all weather conditions. Additionally, the discreetly sewn pockets on the sides and hidden message printed in each color variation around the collar add a touch of uniqueness and style to the product. With a wide range of color combinations to choose from, this product is a great addition to any wardrobe.',
    1,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0005',
    N'EMOTION BEAR HOODIE ZIP MISSOUT',
    N'https://product.hstatic.net/200000195489/product/kem_co_nen_cceb35e8a7be4f6695e060460630a876_grande.jpg',
    30,
    93,
    N'This product is a BASIC style HOODIE ZIP, made of Corduroy fabric. Its high-quality material provides a comfortable and durable texture, making it perfect for daily wear. The hoodie design adds an extra layer of warmth and style, making it a great addition to any casual outfit.',
    2,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0006',
    N'MOOD HOODIE ZIP',
    N'https://product.hstatic.net/200000195489/product/gray_1acc1ce21fce4d0fb1ec1f1b98332636_grande.jpg',
    32,
    198,
    N'This product is a BASIC style HOODIE ZIP, made of Corduroy fabric. Its high-quality material provides a comfortable and durable texture, making it perfect for daily wear. The hoodie design adds an extra layer of warmth and style, making it a great addition to any casual outfit.',
    2,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0007',
    N'PLUS HOODIE',
    N'https://product.hstatic.net/200000195489/product/black_b7a13b4e44554a24a52f5bf12c96a6e5_grande.jpg',
    35,
    150,
    N'This product is a BASIC style HOODIE ZIP, made of Corduroy fabric. Its high-quality material provides a comfortable and durable texture, making it perfect for daily wear. The hoodie design adds an extra layer of warmth and style, making it a great addition to any casual outfit.',
    2,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0008',
    N'YUU EMOTION HOODIE ZIP MISSOUT',
    N'https://product.hstatic.net/200000195489/product/black_notext_96b55bcfe4ae4d78a56b6697eaccb9da_grande.jpg',
    31,
    148,
    N'This product is a BASIC style HOODIE ZIP, made of Corduroy fabric. Its high-quality material provides a comfortable and durable texture, making it perfect for daily wear. The hoodie design adds an extra layer of warmth and style, making it a great addition to any casual outfit.',
    2,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0009',
    N'GREEN WAVE SHORT',
    N'https://product.hstatic.net/200000195489/product/short_2_49fb6e98124e4caf8eec2599ad597a66_grande.jpg',
    12,
    139,
    N'Color: Grey-Black, Black.',
    3,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0010',
    N'POCKET PANTS',
    N'https://product.hstatic.net/200000195489/product/sporty_pants_xam_den_truoc_134bb8ffd3a348a7b0fe97be24ba9dc6_grande.jpg',
    17,
    5,
    N'Color: Grey-Black, Black.',
    3,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0011',
    N'TROUSER PANTS MISSOUT',
    N'https://product.hstatic.net/200000195489/product/black_4f536d887491490fbac05fb474dd22f9_grande.jpg',
    15,
    150,
    N'Color: Grey-Black, Black.',
    3,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0012',
    N'BAMA BORDER BACKPACK MINI',
    N'https://product.hstatic.net/200000017420/product/bl1_7b091ce926da441dbd685756783b9543_grande.jpg',
    20,
    110,
    N'This product is designed with functionality in mind, featuring a 90% waterproof Polyester material that provides protection against the elements. The lining is made of high-quality Nylon imported from South Korea, while the zipper is genuine YKK, ensuring long-lasting durability. The PVC plastic logo and satin woven label add a touch of style to the product.',
    4,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0013',
    N'BAMA SIMPLE BACKPACK 4.0',
    N'https://product.hstatic.net/200000017420/product/picture31_67030201a24747e7b648479ff22d50e7_master.jpg',
    20,
    110,
    N'This product is designed with functionality in mind, featuring a 90% waterproof Polyester material that provides protection against the elements. The lining is made of high-quality Nylon imported from South Korea, while the zipper is genuine YKK, ensuring long-lasting durability. The PVC plastic logo and satin woven label add a touch of style to the product.',
    4,
    1,
    0
)
    INSERT [dbo].[Products]
(
    [
    sku], [
    product_name], [
    image], [
    price], [
    quantity], [
    description], [
    category_id], [
    product_status_id],
[
    is_deleted]
) VALUES
(
    N'P0014',
    N'BAMA BORDER POUCHES',
    N'https://product.hstatic.net/200000017420/product/gt_2_701d50abd38140c7bac3a30c57951316_master.jpg',
    22,
    109,
    N'This product is designed with functionality in mind, featuring a 90% waterproof Polyester material that provides protection against the elements. The lining is made of high-quality Nylon imported from South Korea, while the zipper is genuine YKK, ensuring long-lasting durability. The PVC plastic logo and satin woven label add a touch of style to the product.',
    4,
    1,
    0
)
    GO
    INSERT [dbo].[ProductStatuses]
(
    [
    product_status_id],
[
    product_status]
) VALUES
(
    1,
    N'Available'
)
    INSERT [dbo].[ProductStatuses]
(
    [
    product_status_id],
[
    product_status]
) VALUES
(
    2,
    N'Not- Available'
)
    INSERT [dbo].[ProductStatuses]
(
    [
    product_status_id],
[
    product_status]
) VALUES
(
    3,
    N'Inventory'
)
    GO
    INSERT [dbo].[Roles]
(
    [
    role_id],
[
    role_name]
) VALUES
(
    1,
    N'Admin'
)
    INSERT [dbo].[Roles]
(
    [
    role_id],
[
    role_name]
) VALUES
(
    2,
    N'User'
)
    GO
ALTER TABLE [dbo].[Account] WITH CHECK ADD FOREIGN KEY ([role_id])
    REFERENCES [dbo].[Roles] ([role_id])
    GO
ALTER TABLE [dbo].[OrderItem] WITH CHECK ADD FOREIGN KEY ([order_id])
    REFERENCES [dbo].[Orders] ([order_id])
    GO
ALTER TABLE [dbo].[OrderItem] WITH CHECK ADD FOREIGN KEY ([sku])
    REFERENCES [dbo].[Products] ([sku])
    GO
ALTER TABLE [dbo].[Orders] WITH CHECK ADD FOREIGN KEY ([email])
    REFERENCES [dbo].[Account] ([email])
    GO
ALTER TABLE [dbo].[Orders] WITH CHECK ADD FOREIGN KEY ([order_status_id])
    REFERENCES [dbo].[OrderStatuses] ([order_status_id])
    GO
ALTER TABLE [dbo].[Products] WITH CHECK ADD FOREIGN KEY ([category_id])
    REFERENCES [dbo].[Categories] ([category_id])
    GO
ALTER TABLE [dbo].[Products] WITH CHECK ADD FOREIGN KEY ([product_status_id])
    REFERENCES [dbo].[ProductStatuses] ([product_status_id])
    GO
