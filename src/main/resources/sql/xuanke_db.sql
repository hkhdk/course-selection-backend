/*
 Navicat Premium Data Transfer

 Source Server         : mysql@localhost
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : xuanke_db

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 23/11/2023 15:19:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course_selections
-- ----------------------------
DROP TABLE IF EXISTS `course_selections`;
CREATE TABLE `course_selections`  (
                                      `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
                                      `course_id` bigint UNSIGNED NOT NULL,
                                      `student_id` bigint UNSIGNED NOT NULL,
                                      PRIMARY KEY (`id`) USING BTREE,
                                      UNIQUE INDEX `course_id_2`(`course_id` ASC, `student_id` ASC) USING BTREE,
                                      INDEX `student_id`(`student_id` ASC) USING BTREE,
                                      INDEX `course_id`(`course_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course_selections
-- ----------------------------
INSERT INTO `course_selections` VALUES (16, 10000, 20212447);
INSERT INTO `course_selections` VALUES (28, 10000, 20212485);
INSERT INTO `course_selections` VALUES (51, 10000, 20212486);
INSERT INTO `course_selections` VALUES (9, 10000, 20212494);
INSERT INTO `course_selections` VALUES (43, 10010, 20212443);
INSERT INTO `course_selections` VALUES (18, 10010, 20212485);
INSERT INTO `course_selections` VALUES (37, 10010, 20212496);
INSERT INTO `course_selections` VALUES (17, 10010, 20212507);
INSERT INTO `course_selections` VALUES (58, 10010, 20212508);
INSERT INTO `course_selections` VALUES (48, 10083, 20212472);
INSERT INTO `course_selections` VALUES (42, 10083, 20212512);
INSERT INTO `course_selections` VALUES (38, 10086, 20212452);
INSERT INTO `course_selections` VALUES (56, 10086, 20212457);
INSERT INTO `course_selections` VALUES (45, 10086, 20212472);
INSERT INTO `course_selections` VALUES (10, 10087, 20212438);
INSERT INTO `course_selections` VALUES (29, 10087, 20212485);
INSERT INTO `course_selections` VALUES (14, 10087, 20212491);
INSERT INTO `course_selections` VALUES (44, 10088, 20212432);
INSERT INTO `course_selections` VALUES (7, 10088, 20212436);
INSERT INTO `course_selections` VALUES (31, 10088, 20212443);
INSERT INTO `course_selections` VALUES (39, 10088, 20212445);
INSERT INTO `course_selections` VALUES (23, 10088, 20212464);
INSERT INTO `course_selections` VALUES (20, 11451, 20212418);
INSERT INTO `course_selections` VALUES (35, 11451, 20212442);
INSERT INTO `course_selections` VALUES (4, 11451, 20212453);
INSERT INTO `course_selections` VALUES (25, 11451, 20212457);
INSERT INTO `course_selections` VALUES (1, 11451, 20212462);
INSERT INTO `course_selections` VALUES (30, 11451, 20212465);
INSERT INTO `course_selections` VALUES (59, 11451, 20212483);
INSERT INTO `course_selections` VALUES (57, 11451, 20212499);
INSERT INTO `course_selections` VALUES (13, 11451, 20212502);
INSERT INTO `course_selections` VALUES (34, 11451, 20212507);
INSERT INTO `course_selections` VALUES (26, 11451, 20212514);
INSERT INTO `course_selections` VALUES (22, 12345, 20212426);
INSERT INTO `course_selections` VALUES (2, 12345, 20212433);
INSERT INTO `course_selections` VALUES (49, 12345, 20212434);
INSERT INTO `course_selections` VALUES (5, 12345, 20212453);
INSERT INTO `course_selections` VALUES (40, 12345, 20212456);
INSERT INTO `course_selections` VALUES (46, 17864, 20212491);
INSERT INTO `course_selections` VALUES (41, 19198, 20212423);
INSERT INTO `course_selections` VALUES (50, 19198, 20212449);
INSERT INTO `course_selections` VALUES (32, 19198, 20212481);
INSERT INTO `course_selections` VALUES (12, 19198, 20212483);
INSERT INTO `course_selections` VALUES (60, 19198, 20212510);
INSERT INTO `course_selections` VALUES (47, 23333, 20212461);
INSERT INTO `course_selections` VALUES (15, 23333, 20212482);
INSERT INTO `course_selections` VALUES (33, 23333, 20212486);
INSERT INTO `course_selections` VALUES (54, 23333, 20212489);
INSERT INTO `course_selections` VALUES (53, 44556, 20212459);
INSERT INTO `course_selections` VALUES (8, 44556, 20212465);
INSERT INTO `course_selections` VALUES (3, 78121, 20212418);
INSERT INTO `course_selections` VALUES (36, 78121, 20212425);
INSERT INTO `course_selections` VALUES (19, 78121, 20212481);
INSERT INTO `course_selections` VALUES (21, 78121, 20212506);
INSERT INTO `course_selections` VALUES (55, 78121, 20212510);
INSERT INTO `course_selections` VALUES (6, 96576, 20212432);
INSERT INTO `course_selections` VALUES (11, 96576, 20212436);
INSERT INTO `course_selections` VALUES (52, 96576, 20212442);
INSERT INTO `course_selections` VALUES (24, 96576, 20212492);
INSERT INTO `course_selections` VALUES (27, 96576, 20212498);

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
                            `id` bigint UNSIGNED NOT NULL,
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `teacher_id` bigint UNSIGNED NOT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `teacher_id`(`teacher_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES (10000, '数据结构', 200084);
INSERT INTO `courses` VALUES (10010, '计算机组成原理', 200088);
INSERT INTO `courses` VALUES (10083, '线性代数', 200090);
INSERT INTO `courses` VALUES (10086, '操作系统', 200083);
INSERT INTO `courses` VALUES (10087, '高等数学', 200086);
INSERT INTO `courses` VALUES (10088, '计算机网络', 200091);
INSERT INTO `courses` VALUES (11451, '编译原理', 200095);
INSERT INTO `courses` VALUES (12345, 'C/C++ 程序设计', 200123);
INSERT INTO `courses` VALUES (17864, '软件工程', 200111);
INSERT INTO `courses` VALUES (19198, '分布式基础', 200116);
INSERT INTO `courses` VALUES (23333, '计算机图形学', 200105);
INSERT INTO `courses` VALUES (44556, 'Java 面向对象程序设计', 200101);
INSERT INTO `courses` VALUES (78121, '数据库原理', 200118);
INSERT INTO `courses` VALUES (96576, 'OCaml 函数式编程', 200131);

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
                                `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
                                `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES (1, '计算机科学与软件学院、大数据学院', '李云');
INSERT INTO `departments` VALUES (2, '电子信息学院', '王三');
INSERT INTO `departments` VALUES (3, '数学院', '黄睿');
INSERT INTO `departments` VALUES (4, '文学院', '张全');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
                             `id` bigint UNSIGNED NOT NULL,
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                             `sex` bit(1) NOT NULL,
                             `age` int UNSIGNED NOT NULL,
                             `dept_id` int UNSIGNED NOT NULL,
                             `class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `dept_id`(`dept_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC STATS_AUTO_RECALC = 0;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (20212418, '卢璐', b'1', 22, 1, '大数据1班');
INSERT INTO `students` VALUES (20212419, '毛睿', b'1', 24, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212420, '袁子韬', b'0', 21, 1, '大数据2班');
INSERT INTO `students` VALUES (20212421, '尹杰宏', b'0', 21, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212422, '冯嘉伦', b'0', 20, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212423, '任云熙', b'1', 22, 1, '大数据2班');
INSERT INTO `students` VALUES (20212424, '严震南', b'0', 20, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212425, '卢璐', b'1', 21, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212426, '潘嘉伦', b'1', 24, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212427, '侯嘉伦', b'1', 22, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212428, '尹杰宏', b'0', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212429, '常致远', b'1', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212430, '姚岚', b'0', 19, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212431, '余子韬', b'1', 23, 1, '大数据2班');
INSERT INTO `students` VALUES (20212432, '何云熙', b'1', 22, 1, '大数据2班');
INSERT INTO `students` VALUES (20212433, '廖睿', b'1', 24, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212434, '徐嘉伦', b'1', 23, 1, '大数据1班');
INSERT INTO `students` VALUES (20212435, '何岚', b'1', 24, 1, '大数据1班');
INSERT INTO `students` VALUES (20212436, '张宇宁', b'0', 19, 1, '大数据2班');
INSERT INTO `students` VALUES (20212437, '向睿', b'1', 22, 1, '大数据2班');
INSERT INTO `students` VALUES (20212438, '何璐', b'1', 19, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212439, '黎宇宁', b'1', 23, 1, '大数据1班');
INSERT INTO `students` VALUES (20212440, '郭晓明', b'0', 24, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212441, '陶詩涵', b'0', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212442, '崔嘉伦', b'0', 21, 1, '大数据1班');
INSERT INTO `students` VALUES (20212443, '彭致远', b'0', 19, 1, '大数据1班');
INSERT INTO `students` VALUES (20212444, '崔子韬', b'1', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212445, '苏嘉伦', b'0', 19, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212446, '薛嘉伦', b'1', 18, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212447, '薛云熙', b'1', 23, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212448, '邓云熙', b'1', 23, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212449, '莫宇宁', b'1', 22, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212450, '史秀英', b'0', 22, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212451, '崔震南', b'1', 22, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212452, '顾子异', b'1', 23, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212453, '余杰宏', b'0', 20, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212454, '余嘉伦', b'0', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212455, '周子异', b'1', 20, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212456, '顾宇宁', b'0', 19, 1, '大数据1班');
INSERT INTO `students` VALUES (20212457, '袁杰宏', b'0', 21, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212458, '宋詩涵', b'0', 18, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212459, '戴嘉伦', b'0', 22, 1, '大数据1班');
INSERT INTO `students` VALUES (20212460, '贺子异', b'0', 19, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212461, '王岚', b'0', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212462, '金子异', b'0', 21, 1, '大数据1班');
INSERT INTO `students` VALUES (20212463, '萧睿', b'1', 22, 1, '大数据2班');
INSERT INTO `students` VALUES (20212464, '卢致远', b'0', 19, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212465, '傅致远', b'0', 22, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212466, '莫震南', b'1', 19, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212467, '贾宇宁', b'0', 20, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212468, '秦子韬', b'0', 19, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212469, '萧致远', b'0', 19, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212470, '姚云熙', b'1', 22, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212471, '侯詩涵', b'0', 23, 1, '大数据2班');
INSERT INTO `students` VALUES (20212472, '梁岚', b'0', 20, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212473, '周璐', b'0', 19, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212474, '龚云熙', b'1', 23, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212475, '汪晓明', b'1', 22, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212476, '吴宇宁', b'1', 22, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212477, '贺秀英', b'1', 19, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212478, '毛宇宁', b'0', 19, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212479, '杨震南', b'0', 19, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212480, '孟云熙', b'1', 20, 1, '大数据2班');
INSERT INTO `students` VALUES (20212481, '郭嘉伦', b'1', 19, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212482, '蔡云熙', b'1', 19, 1, '大数据1班');
INSERT INTO `students` VALUES (20212483, '廖致远', b'1', 22, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212484, '雷嘉伦', b'1', 22, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212485, '高震南', b'0', 24, 1, '大数据1班');
INSERT INTO `students` VALUES (20212486, '史云熙', b'0', 18, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212487, '姚安琪', b'1', 23, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212488, '朱杰宏', b'1', 19, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212489, '冯子异', b'1', 23, 1, '大数据1班');
INSERT INTO `students` VALUES (20212490, '吴致远', b'1', 23, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212491, '郑云熙', b'0', 20, 1, '大数据1班');
INSERT INTO `students` VALUES (20212492, '余云熙', b'1', 20, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212493, '罗宇宁', b'1', 20, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212494, '吕安琪', b'0', 19, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212495, '钱璐', b'0', 24, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212496, '马云熙', b'1', 22, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212497, '丁致远', b'1', 23, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212498, '向睿', b'1', 22, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212499, '于詩涵', b'1', 23, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212500, '邱岚', b'0', 21, 1, '大数据1班');
INSERT INTO `students` VALUES (20212501, '戴震南', b'1', 22, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212502, '莫詩涵', b'1', 23, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212503, '陶子韬', b'1', 19, 1, '计算机科学与技术3班');
INSERT INTO `students` VALUES (20212504, '郝睿', b'1', 18, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212505, '何璐', b'0', 23, 1, '软件工程2班');
INSERT INTO `students` VALUES (20212506, '江詩涵', b'0', 21, 1, '大数据2班');
INSERT INTO `students` VALUES (20212507, '夏云熙', b'1', 18, 1, '大数据1班');
INSERT INTO `students` VALUES (20212508, '阎杰宏', b'0', 22, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212509, '崔宇宁', b'1', 19, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212510, '曾璐', b'0', 22, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212511, '崔安琪', b'1', 22, 1, '软件工程1班');
INSERT INTO `students` VALUES (20212512, '薛嘉伦', b'1', 19, 1, '软件工程3班');
INSERT INTO `students` VALUES (20212513, '阎睿', b'1', 21, 1, '大数据1班');
INSERT INTO `students` VALUES (20212514, '任子异', b'0', 21, 1, '计算机科学与技术2班');
INSERT INTO `students` VALUES (20212515, '叶致远', b'0', 21, 1, '大数据2班');
INSERT INTO `students` VALUES (20212516, '吕秀英', b'1', 20, 1, '计算机科学与技术1班');
INSERT INTO `students` VALUES (20212517, '蒋岚', b'0', 20, 1, '大数据2班');

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
                             `id` bigint UNSIGNED NOT NULL,
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                             `sex` bit(1) NOT NULL,
                             `age` int UNSIGNED NOT NULL,
                             `edu_background` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                             `dept_id` int UNSIGNED NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `dept_id`(`dept_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (200083, '钟云熙', b'0', 35, '中山大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200084, '余嘉伦', b'1', 55, '华南理工大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200085, '姜惠妹', b'0', 45, '南京大学', '教授', 1);
INSERT INTO `teachers` VALUES (200086, '彭岚', b'0', 46, '武汉大学', '教授', 1);
INSERT INTO `teachers` VALUES (200087, '苏子异', b'1', 51, '南京大学', '教授', 1);
INSERT INTO `teachers` VALUES (200088, '郑杰宏', b'0', 49, '深圳大学', '教授', 1);
INSERT INTO `teachers` VALUES (200089, '郭國榮', b'0', 54, '清华大学', '教授', 1);
INSERT INTO `teachers` VALUES (200090, '戴淑怡', b'1', 51, '清华大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200091, '沈安琪', b'0', 38, '武汉大学', '教授', 1);
INSERT INTO `teachers` VALUES (200092, '邹嘉伦', b'1', 32, '清华大学', '教授', 1);
INSERT INTO `teachers` VALUES (200093, '顧慧珊', b'1', 37, '华南理工大学', '教授', 1);
INSERT INTO `teachers` VALUES (200094, '刘璐', b'1', 41, '华南师范大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200095, '任震南', b'0', 38, '南京大学', '教授', 1);
INSERT INTO `teachers` VALUES (200096, '吴云熙', b'1', 56, '武汉大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200097, '马睿', b'1', 41, '杭州电子科技大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200098, '鐘家強', b'1', 36, '华南理工大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200099, '葉學友', b'0', 53, '华南理工大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200100, '袁子韬', b'1', 42, '南京大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200101, '駱國權', b'1', 46, '中山大学', '教授', 1);
INSERT INTO `teachers` VALUES (200102, '佘明', b'1', 45, '深圳大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200103, '雷力申', b'1', 49, '暨南大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200104, '馬志明', b'1', 34, '华南理工大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200105, '高子韬', b'1', 31, '杭州电子科技大学', '教授', 1);
INSERT INTO `teachers` VALUES (200106, '谭璐', b'1', 55, '四川大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200107, '佘曉彤', b'1', 58, '南京大学', '教授', 1);
INSERT INTO `teachers` VALUES (200108, '曹子异', b'0', 56, '华南师范大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200109, '區慧珊', b'1', 46, '华南理工大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200110, '马杰宏', b'1', 52, '暨南大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200111, '唐梓晴', b'1', 49, '中山大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200112, '孙宇宁', b'0', 39, '杭州电子科技大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200113, '孫國權', b'1', 48, '华南理工大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200114, '任云熙', b'1', 30, '华南师范大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200115, '唐詩涵', b'1', 39, '南京大学', '教授', 1);
INSERT INTO `teachers` VALUES (200116, '郑睿', b'0', 36, '深圳大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200117, '陶世榮', b'1', 48, '中山大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200118, '蔡慧嫻', b'1', 37, '华东师范大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200119, '孔詩涵', b'1', 56, '南京大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200120, '馬德華', b'0', 51, '华南师范大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200121, '應安娜', b'0', 54, '华东师范大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200122, '馬潤發', b'0', 51, '中山大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200123, '蔣麗欣', b'1', 55, '华东师范大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200124, '陈震南', b'1', 32, '深圳大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200125, '彭仲賢', b'0', 30, '暨南大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200126, '许震南', b'0', 36, '武汉大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200127, '關慧珊', b'0', 50, '中山大学', '教授', 1);
INSERT INTO `teachers` VALUES (200128, '蔣富城', b'1', 39, '华东师范大学', '副教授', 1);
INSERT INTO `teachers` VALUES (200129, '高頴思', b'1', 43, '南京大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200130, '羅淑怡', b'1', 55, '华东师范大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200131, '高晓明', b'1', 46, '中山大学', '讲师', 1);
INSERT INTO `teachers` VALUES (200132, '魏詩涵', b'1', 57, '华南理工大学', '讲师', 1);

-- ----------------------------
-- Table structure for user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `user_permissions`;
CREATE TABLE `user_permissions`  (
                                     `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
                                     `user_id` int UNSIGNED NOT NULL,
                                     `permission_id` int UNSIGNED NOT NULL,
                                     PRIMARY KEY (`id`) USING BTREE,
                                     INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_permissions
-- ----------------------------
INSERT INTO `user_permissions` VALUES (1, 1, 1);
INSERT INTO `user_permissions` VALUES (2, 1, 2);
INSERT INTO `user_permissions` VALUES (3, 1, 11);
INSERT INTO `user_permissions` VALUES (4, 1, 12);
INSERT INTO `user_permissions` VALUES (5, 1, 21);
INSERT INTO `user_permissions` VALUES (6, 1, 22);
INSERT INTO `user_permissions` VALUES (7, 1, 31);
INSERT INTO `user_permissions` VALUES (8, 1, 32);
INSERT INTO `user_permissions` VALUES (9, 1, 51);
INSERT INTO `user_permissions` VALUES (10, 1, 52);
INSERT INTO `user_permissions` VALUES (11, 1, 61);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
                          `login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `password_sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                          `create_time` date NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `login_name`(`login_name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '[54, -29, 53, -25, -100, 111, 59, -77, 63, -30, 91, 14, 35, -101, -112, -101]', NULL, '2023-09-16');

SET FOREIGN_KEY_CHECKS = 1;
