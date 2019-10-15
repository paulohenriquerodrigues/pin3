PGDMP         5            	    w            Pin3    11.5    11.5 @    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    24584    Pin3    DATABASE     d   CREATE DATABASE "Pin3" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';
    DROP DATABASE "Pin3";
             postgres    false            �            1259    24610    tbboleto    TABLE     �   CREATE TABLE public.tbboleto (
    id integer NOT NULL,
    codigobarras character(100),
    linhadigitavel character(100),
    vencimento date,
    pago boolean
);
    DROP TABLE public.tbboleto;
       public         postgres    false            �            1259    24608    tbboleto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbboleto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tbboleto_id_seq;
       public       postgres    false    201            �           0    0    tbboleto_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.tbboleto_id_seq OWNED BY public.tbboleto.id;
            public       postgres    false    200            �            1259    24618    tbcartao    TABLE     �   CREATE TABLE public.tbcartao (
    id integer NOT NULL,
    usuarioid integer,
    numero character(50),
    nome character(50),
    digito integer,
    validade character(10)
);
    DROP TABLE public.tbcartao;
       public         postgres    false            �            1259    24616    tbcartao_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbcartao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tbcartao_id_seq;
       public       postgres    false    203            �           0    0    tbcartao_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.tbcartao_id_seq OWNED BY public.tbcartao.id;
            public       postgres    false    202            �            1259    24631    tbcategoria    TABLE     d   CREATE TABLE public.tbcategoria (
    id integer NOT NULL,
    descricao character(100) NOT NULL
);
    DROP TABLE public.tbcategoria;
       public         postgres    false            �            1259    24629    tbcategoria_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbcategoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tbcategoria_id_seq;
       public       postgres    false    205            �           0    0    tbcategoria_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tbcategoria_id_seq OWNED BY public.tbcategoria.id;
            public       postgres    false    204            �            1259    24597 
   tbendereco    TABLE     �   CREATE TABLE public.tbendereco (
    id integer NOT NULL,
    cidade character(50),
    bairro character(50),
    logradouro character(50),
    numero integer,
    complemento character(200),
    cep character(20)
);
    DROP TABLE public.tbendereco;
       public         postgres    false            �            1259    24595    tbendereco_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbendereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.tbendereco_id_seq;
       public       postgres    false    199            �           0    0    tbendereco_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.tbendereco_id_seq OWNED BY public.tbendereco.id;
            public       postgres    false    198            �            1259    24678    tbitenspedido    TABLE     �   CREATE TABLE public.tbitenspedido (
    pedidoid integer NOT NULL,
    produtoid integer NOT NULL,
    quantidade integer NOT NULL
);
 !   DROP TABLE public.tbitenspedido;
       public         postgres    false            �            1259    24639    tbpedido    TABLE     �   CREATE TABLE public.tbpedido (
    id integer NOT NULL,
    usuarioid integer,
    enderecoid integer,
    cartaoid integer,
    boletoid integer,
    status character(20)
);
    DROP TABLE public.tbpedido;
       public         postgres    false            �            1259    24637    tbpedido_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbpedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tbpedido_id_seq;
       public       postgres    false    207            �           0    0    tbpedido_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.tbpedido_id_seq OWNED BY public.tbpedido.id;
            public       postgres    false    206            �            1259    24667 	   tbproduto    TABLE     S  CREATE TABLE public.tbproduto (
    id integer NOT NULL,
    categoriaid integer,
    descricao character(100),
    datavalidade date,
    datafabricacao date,
    preco double precision,
    laboratorio character(100),
    lote integer,
    quantidade integer,
    usocontinuo boolean,
    controlado boolean,
    titulo character(40)
);
    DROP TABLE public.tbproduto;
       public         postgres    false            �            1259    24665    tbproduto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbproduto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.tbproduto_id_seq;
       public       postgres    false    209            �           0    0    tbproduto_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.tbproduto_id_seq OWNED BY public.tbproduto.id;
            public       postgres    false    208            �            1259    24589 	   tbusuario    TABLE       CREATE TABLE public.tbusuario (
    id integer NOT NULL,
    nome character(50),
    cpf character(20),
    email character(50),
    administrador boolean,
    datanascimento date,
    telefone character(20),
    enderecousuario integer NOT NULL,
    senha character(40)
);
    DROP TABLE public.tbusuario;
       public         postgres    false            �            1259    24587    tbusuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tbusuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.tbusuario_id_seq;
       public       postgres    false    197            �           0    0    tbusuario_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.tbusuario_id_seq OWNED BY public.tbusuario.id;
            public       postgres    false    196            �           2604    24613    tbboleto id    DEFAULT     j   ALTER TABLE ONLY public.tbboleto ALTER COLUMN id SET DEFAULT nextval('public.tbboleto_id_seq'::regclass);
 :   ALTER TABLE public.tbboleto ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    201    201            �           2604    24621    tbcartao id    DEFAULT     j   ALTER TABLE ONLY public.tbcartao ALTER COLUMN id SET DEFAULT nextval('public.tbcartao_id_seq'::regclass);
 :   ALTER TABLE public.tbcartao ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    202    203    203            �           2604    24634    tbcategoria id    DEFAULT     p   ALTER TABLE ONLY public.tbcategoria ALTER COLUMN id SET DEFAULT nextval('public.tbcategoria_id_seq'::regclass);
 =   ALTER TABLE public.tbcategoria ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    204    205    205            �           2604    24600    tbendereco id    DEFAULT     n   ALTER TABLE ONLY public.tbendereco ALTER COLUMN id SET DEFAULT nextval('public.tbendereco_id_seq'::regclass);
 <   ALTER TABLE public.tbendereco ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    199    199            �           2604    24642    tbpedido id    DEFAULT     j   ALTER TABLE ONLY public.tbpedido ALTER COLUMN id SET DEFAULT nextval('public.tbpedido_id_seq'::regclass);
 :   ALTER TABLE public.tbpedido ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    206    207    207            �           2604    24670    tbproduto id    DEFAULT     l   ALTER TABLE ONLY public.tbproduto ALTER COLUMN id SET DEFAULT nextval('public.tbproduto_id_seq'::regclass);
 ;   ALTER TABLE public.tbproduto ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    209    208    209            �           2604    24592    tbusuario id    DEFAULT     l   ALTER TABLE ONLY public.tbusuario ALTER COLUMN id SET DEFAULT nextval('public.tbusuario_id_seq'::regclass);
 ;   ALTER TABLE public.tbusuario ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197            ~          0    24610    tbboleto 
   TABLE DATA               V   COPY public.tbboleto (id, codigobarras, linhadigitavel, vencimento, pago) FROM stdin;
    public       postgres    false    201   $G       �          0    24618    tbcartao 
   TABLE DATA               Q   COPY public.tbcartao (id, usuarioid, numero, nome, digito, validade) FROM stdin;
    public       postgres    false    203   AG       �          0    24631    tbcategoria 
   TABLE DATA               4   COPY public.tbcategoria (id, descricao) FROM stdin;
    public       postgres    false    205   ^G       |          0    24597 
   tbendereco 
   TABLE DATA               ^   COPY public.tbendereco (id, cidade, bairro, logradouro, numero, complemento, cep) FROM stdin;
    public       postgres    false    199   {G       �          0    24678    tbitenspedido 
   TABLE DATA               H   COPY public.tbitenspedido (pedidoid, produtoid, quantidade) FROM stdin;
    public       postgres    false    210   #H       �          0    24639    tbpedido 
   TABLE DATA               Y   COPY public.tbpedido (id, usuarioid, enderecoid, cartaoid, boletoid, status) FROM stdin;
    public       postgres    false    207   @H       �          0    24667 	   tbproduto 
   TABLE DATA               �   COPY public.tbproduto (id, categoriaid, descricao, datavalidade, datafabricacao, preco, laboratorio, lote, quantidade, usocontinuo, controlado, titulo) FROM stdin;
    public       postgres    false    209   ]H       z          0    24589 	   tbusuario 
   TABLE DATA               z   COPY public.tbusuario (id, nome, cpf, email, administrador, datanascimento, telefone, enderecousuario, senha) FROM stdin;
    public       postgres    false    197   zH       �           0    0    tbboleto_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tbboleto_id_seq', 1, false);
            public       postgres    false    200            �           0    0    tbcartao_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tbcartao_id_seq', 1, false);
            public       postgres    false    202            �           0    0    tbcategoria_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tbcategoria_id_seq', 1, false);
            public       postgres    false    204            �           0    0    tbendereco_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tbendereco_id_seq', 12, true);
            public       postgres    false    198            �           0    0    tbpedido_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tbpedido_id_seq', 1, false);
            public       postgres    false    206            �           0    0    tbproduto_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.tbproduto_id_seq', 1, false);
            public       postgres    false    208            �           0    0    tbusuario_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.tbusuario_id_seq', 8, true);
            public       postgres    false    196            �           2606    24615    tbboleto tbboleto_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tbboleto
    ADD CONSTRAINT tbboleto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.tbboleto DROP CONSTRAINT tbboleto_pkey;
       public         postgres    false    201            �           2606    24628    tbcartao tbcartao_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tbcartao
    ADD CONSTRAINT tbcartao_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.tbcartao DROP CONSTRAINT tbcartao_pkey;
       public         postgres    false    203            �           2606    24636    tbcategoria tbcategoria_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tbcategoria
    ADD CONSTRAINT tbcategoria_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tbcategoria DROP CONSTRAINT tbcategoria_pkey;
       public         postgres    false    205            �           2606    24602    tbendereco tbendereco_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tbendereco
    ADD CONSTRAINT tbendereco_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tbendereco DROP CONSTRAINT tbendereco_pkey;
       public         postgres    false    199            �           2606    24644    tbpedido tbpedido_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tbpedido
    ADD CONSTRAINT tbpedido_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.tbpedido DROP CONSTRAINT tbpedido_pkey;
       public         postgres    false    207            �           2606    24672    tbproduto tbproduto_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tbproduto
    ADD CONSTRAINT tbproduto_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.tbproduto DROP CONSTRAINT tbproduto_pkey;
       public         postgres    false    209            �           2606    24594    tbusuario tbusuario_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tbusuario
    ADD CONSTRAINT tbusuario_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.tbusuario DROP CONSTRAINT tbusuario_pkey;
       public         postgres    false    197            �           2606    24660    tbpedido boletoid    FK CONSTRAINT     t   ALTER TABLE ONLY public.tbpedido
    ADD CONSTRAINT boletoid FOREIGN KEY (boletoid) REFERENCES public.tbboleto(id);
 ;   ALTER TABLE ONLY public.tbpedido DROP CONSTRAINT boletoid;
       public       postgres    false    3054    207    201            �           2606    24655    tbpedido cartaoid    FK CONSTRAINT     t   ALTER TABLE ONLY public.tbpedido
    ADD CONSTRAINT cartaoid FOREIGN KEY (cartaoid) REFERENCES public.tbcartao(id);
 ;   ALTER TABLE ONLY public.tbpedido DROP CONSTRAINT cartaoid;
       public       postgres    false    3056    207    203            �           2606    24673    tbproduto categoriaid    FK CONSTRAINT     ~   ALTER TABLE ONLY public.tbproduto
    ADD CONSTRAINT categoriaid FOREIGN KEY (categoriaid) REFERENCES public.tbcategoria(id);
 ?   ALTER TABLE ONLY public.tbproduto DROP CONSTRAINT categoriaid;
       public       postgres    false    209    3058    205            �           2606    24650    tbpedido enderecoid    FK CONSTRAINT     z   ALTER TABLE ONLY public.tbpedido
    ADD CONSTRAINT enderecoid FOREIGN KEY (enderecoid) REFERENCES public.tbendereco(id);
 =   ALTER TABLE ONLY public.tbpedido DROP CONSTRAINT enderecoid;
       public       postgres    false    3052    207    199            �           2606    24681    tbitenspedido pedidoid    FK CONSTRAINT     y   ALTER TABLE ONLY public.tbitenspedido
    ADD CONSTRAINT pedidoid FOREIGN KEY (pedidoid) REFERENCES public.tbpedido(id);
 @   ALTER TABLE ONLY public.tbitenspedido DROP CONSTRAINT pedidoid;
       public       postgres    false    210    3060    207            �           2606    24686    tbitenspedido produtoid    FK CONSTRAINT     |   ALTER TABLE ONLY public.tbitenspedido
    ADD CONSTRAINT produtoid FOREIGN KEY (produtoid) REFERENCES public.tbproduto(id);
 A   ALTER TABLE ONLY public.tbitenspedido DROP CONSTRAINT produtoid;
       public       postgres    false    210    209    3062            �           2606    24603    tbusuario usuario_endereco    FK CONSTRAINT     �   ALTER TABLE ONLY public.tbusuario
    ADD CONSTRAINT usuario_endereco FOREIGN KEY (enderecousuario) REFERENCES public.tbendereco(id);
 D   ALTER TABLE ONLY public.tbusuario DROP CONSTRAINT usuario_endereco;
       public       postgres    false    199    197    3052            �           2606    24622    tbcartao usuario_id    FK CONSTRAINT     x   ALTER TABLE ONLY public.tbcartao
    ADD CONSTRAINT usuario_id FOREIGN KEY (usuarioid) REFERENCES public.tbusuario(id);
 =   ALTER TABLE ONLY public.tbcartao DROP CONSTRAINT usuario_id;
       public       postgres    false    197    203    3050            �           2606    24645    tbpedido usuarioid    FK CONSTRAINT     w   ALTER TABLE ONLY public.tbpedido
    ADD CONSTRAINT usuarioid FOREIGN KEY (usuarioid) REFERENCES public.tbusuario(id);
 <   ALTER TABLE ONLY public.tbpedido DROP CONSTRAINT usuarioid;
       public       postgres    false    197    3050    207            ~      x������ � �      �      x������ � �      �      x������ � �      |   �   x���1
� ��z<�'�5�aﰍ�ZB6ޟ�[��	�/^�uc��7}=z�=��MGZ��&�O�ӑSͪ�����Q��o�� ~�x|���S��7��A/O��^>�ރ^>�>�^>����W�����`��[{s�נ�:b#��      �      x������ � �      �      x������ � �      �      x������ � �      z   V   x�3�,HM)�W p@��CznbfI�q��q����1��!P��h��tp���6���6C�������j1Hgr\�  ��     