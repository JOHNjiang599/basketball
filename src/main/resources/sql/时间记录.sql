
-- 在实际开发中，每条数据的创建时间和修改时间，尽量不需要应用程序去记录，
-- 而由数据库获取当前时间自动记录创建时间，获取当前时间自动记录修改时间。

-- 2、创建语句
-- （1）–添加CreateTime 设置默认时间 CURRENT_TIMESTAMP
ALTER TABLE table_name
ADD COLUMN  CreateTime datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间';

-- （2）–修改CreateTime 设置默认时间 CURRENT_TIMESTAMP
ALTER TABLE table_name
MODIFY COLUMN CreateTime datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间';

--  （3）–添加UpdateTime 设置 默认时间 CURRENT_TIMESTAMP 设置更新时间为 ON UPDATE CURRENT_TIMESTAMP
ALTER TABLE table_name
ADD COLUMN UpdateTime timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间';

--  （4）–修改 UpdateTime 设置 默认时间 CURRENT_TIMESTAMP 设置更新时间为 ON UPDATE CURRENT_TIMESTAMP
ALTER TABLE table_name
MODIFY COLUMN UpdateTime timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间';