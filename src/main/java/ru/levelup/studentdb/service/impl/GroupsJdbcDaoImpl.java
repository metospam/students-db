package ru.levelup.studentdb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.DaoService;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GroupsJdbcDaoImpl implements DaoService<Group> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void save(Group group) {
        String insertSql = "insert into edu_schema.groups (groupname) values (:groupname)";
        String updateSql = "update edu_schema.groups set groupname = :groupname where id = :id";

        if(group.getId() == null){
            namedParameterJdbcTemplate.update(insertSql, Map.of(
                    "groupname", group.getName()
            ));
        } else {
            namedParameterJdbcTemplate.update(updateSql, Map.of(
                    "id", group.getId(),
                    "groupname", group.getName()
            ));
        }
    }

    @Override
    public List<Group> findAll() {
        String sql = "select id, groupname from edu_schema.groups";
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> new Group(
                rs.getLong(1),
                rs.getString(2)
        ));
    }
}
