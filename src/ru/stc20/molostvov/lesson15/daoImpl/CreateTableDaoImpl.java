package ru.stc20.molostvov.lesson15.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.stc20.molostvov.lesson15.connectionManagerJDBCImpl.ConnectionManagerJDBCImp;
import ru.stc20.molostvov.lesson15.dao.CreateTableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableDaoImpl implements CreateTableDao {
    private static final Logger logger = LogManager.getLogger(CreateTableDaoImpl.class);
    private static final String CREATE_TABLE = "CREATE SCHEMA lesson15;\n" +
            "\n" +
            "\n" +
            "ALTER SCHEMA lesson15 OWNER TO postgres;\n" +
            "\n" +
            "SET default_tablespace = '';\n" +
            "\n" +
            "SET default_with_oids = false;\n" +
            "\n" +
            "--\n" +
            "-- Name: USER; Type: TABLE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE TABLE lesson15.\"USER\" (\n" +
            "    id integer NOT NULL,\n" +
            "    name character varying(30) NOT NULL,\n" +
            "    birthday character varying(20) NOT NULL,\n" +
            "    city character varying(255) NOT NULL,\n" +
            "    email character varying(255) NOT NULL,\n" +
            "    description character varying(255),\n" +
            "    login_id integer NOT NULL\n" +
            ");\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.\"USER\" OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: USER_id_seq; Type: SEQUENCE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE SEQUENCE lesson15.\"USER_id_seq\"\n" +
            "    START WITH 1\n" +
            "    INCREMENT BY 1\n" +
            "    NO MINVALUE\n" +
            "    NO MAXVALUE\n" +
            "    CACHE 1;\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.\"USER_id_seq\" OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: USER_id_seq; Type: SEQUENCE OWNED BY; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER SEQUENCE lesson15.\"USER_id_seq\" OWNED BY lesson15.\"USER\".id;\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: USER_login_id_seq; Type: SEQUENCE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE SEQUENCE lesson15.\"USER_login_id_seq\"\n" +
            "    START WITH 1\n" +
            "    INCREMENT BY 1\n" +
            "    NO MINVALUE\n" +
            "    NO MAXVALUE\n" +
            "    CACHE 1;\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.\"USER_login_id_seq\" OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: USER_login_id_seq; Type: SEQUENCE OWNED BY; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER SEQUENCE lesson15.\"USER_login_id_seq\" OWNED BY lesson15.\"USER\".login_id;\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: logs; Type: TABLE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE TABLE lesson15.logs (\n" +
            "    log_id character varying(255) NOT NULL,\n" +
            "    date date NOT NULL,\n" +
            "    log_level character varying(255) NOT NULL,\n" +
            "    message character varying(254),\n" +
            "    exception character varying(255) NOT NULL\n" +
            ");\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.logs OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: role; Type: TABLE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE TABLE lesson15.role (\n" +
            "    id integer NOT NULL,\n" +
            "    name character varying(20) NOT NULL,\n" +
            "    description character varying(255)\n" +
            ");\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.role OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: role_id_seq; Type: SEQUENCE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE SEQUENCE lesson15.role_id_seq\n" +
            "    START WITH 1\n" +
            "    INCREMENT BY 1\n" +
            "    NO MINVALUE\n" +
            "    NO MAXVALUE\n" +
            "    CACHE 1;\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.role_id_seq OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER SEQUENCE lesson15.role_id_seq OWNED BY lesson15.role.id;\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role; Type: TABLE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE TABLE lesson15.user_role (\n" +
            "    id integer NOT NULL,\n" +
            "    user_id integer NOT NULL,\n" +
            "    role_id integer NOT NULL\n" +
            ");\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.user_role OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role_id_seq; Type: SEQUENCE; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE SEQUENCE lesson15.user_role_id_seq\n" +
            "    START WITH 1\n" +
            "    INCREMENT BY 1\n" +
            "    NO MINVALUE\n" +
            "    NO MAXVALUE\n" +
            "    CACHE 1;\n" +
            "\n" +
            "\n" +
            "ALTER TABLE lesson15.user_role_id_seq OWNER TO postgres;\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER SEQUENCE lesson15.user_role_id_seq OWNED BY lesson15.user_role.id;\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: USER id; Type: DEFAULT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.\"USER\" ALTER COLUMN id SET DEFAULT nextval('lesson15.\"USER_id_seq\"'::regclass);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: USER login_id; Type: DEFAULT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.\"USER\" ALTER COLUMN login_id SET DEFAULT nextval('lesson15.\"USER_login_id_seq\"'::regclass);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: role id; Type: DEFAULT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.role ALTER COLUMN id SET DEFAULT nextval('lesson15.role_id_seq'::regclass);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role id; Type: DEFAULT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.user_role ALTER COLUMN id SET DEFAULT nextval('lesson15.user_role_id_seq'::regclass);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Data for Name: USER; Type: TABLE DATA; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "INSERT INTO lesson15.\"USER\" VALUES (6, 'Григорий', '20.06.2866', 'Москва', 'Grisha@mail.ru', '', 6);\n" +
            "INSERT INTO lesson15.\"USER\" VALUES (7, 'Настя', '20.06.1966', 'Москва', 'Nastya@mail.ru', '', 7);\n" +
            "INSERT INTO lesson15.\"USER\" VALUES (8, 'Вася', '20.06.1966', 'Москва', 'VasyaDrugoy@mail.ru', 'Тоже Вася', 8);\n" +
            "INSERT INTO lesson15.\"USER\" VALUES (9, 'Вася', '20.06.1866', 'Москва', 'Vasya@mail.ru', 'Василий', 9);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: USER_id_seq; Type: SEQUENCE SET; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "SELECT pg_catalog.setval('lesson15.\"USER_id_seq\"', 26, true);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: USER_login_id_seq; Type: SEQUENCE SET; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "SELECT pg_catalog.setval('lesson15.\"USER_login_id_seq\"', 26, true);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Data for Name: logs; Type: TABLE DATA; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "INSERT INTO lesson15.logs VALUES ('2cd0af34-3214-11ea-b492-4ccc6a9453c2', '2020-01-08', 'ERROR', 'Error', 'java.sql.BatchUpdateException: Batch entry 0 INSERT into lesson15.\"USER\"(name, birthday, city, email, description) values (''Григорий'',''20.06.2866'',''Москва'',''Grisha@mail.ru'','''') was aborted: ОШИБКА: повторяющееся значение ключа нарушает ограничение уникаль');\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Data for Name: role; Type: TABLE DATA; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "INSERT INTO lesson15.role VALUES (1, 'Administration', 'Администрация');\n" +
            "INSERT INTO lesson15.role VALUES (2, 'Clients', 'Клиенты');\n" +
            "INSERT INTO lesson15.role VALUES (3, 'Billing', 'Транзакция?');\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: role_id_seq; Type: SEQUENCE SET; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "SELECT pg_catalog.setval('lesson15.role_id_seq', 1, false);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Data for Name: user_role; Type: TABLE DATA; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "SELECT pg_catalog.setval('lesson15.user_role_id_seq', 1, false);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: logs logs_pk; Type: CONSTRAINT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.logs\n" +
            "    ADD CONSTRAINT logs_pk PRIMARY KEY (log_id);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: role role_pk; Type: CONSTRAINT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.role\n" +
            "    ADD CONSTRAINT role_pk PRIMARY KEY (id);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: USER user_pk; Type: CONSTRAINT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.\"USER\"\n" +
            "    ADD CONSTRAINT user_pk PRIMARY KEY (id);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role user_role_pk; Type: CONSTRAINT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.user_role\n" +
            "    ADD CONSTRAINT user_role_pk PRIMARY KEY (id);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_email_uindex; Type: INDEX; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "CREATE UNIQUE INDEX user_email_uindex ON lesson15.\"USER\" USING btree (email);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role user_role_role_id_fk; Type: FK CONSTRAINT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.user_role\n" +
            "    ADD CONSTRAINT user_role_role_id_fk FOREIGN KEY (role_id) REFERENCES lesson15.role(id);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- Name: user_role user_role_user_id_fk; Type: FK CONSTRAINT; Schema: lesson15; Owner: postgres\n" +
            "--\n" +
            "\n" +
            "ALTER TABLE ONLY lesson15.user_role\n" +
            "    ADD CONSTRAINT user_role_user_id_fk FOREIGN KEY (user_id) REFERENCES lesson15.\"USER\"(id);\n" +
            "\n" +
            "\n" +
            "--\n" +
            "-- PostgreSQL database dump complete\n" +
            "--\n" +
            "\n";

    @Override
    public void createTable() {
        try (Connection connection = ConnectionManagerJDBCImp.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(CREATE_TABLE)) {
                statement.execute();
            }
        } catch (SQLException e) {
            logger.error("Error", e);       }
    }
}
