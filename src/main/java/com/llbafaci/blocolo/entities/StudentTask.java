package com.llbafaci.blocolo.entities;

import com.llbafaci.blocolo.dtos.StudentTaskDto;

public class StudentTask {
    int studentId;
    int taskId;

    public StudentTask(
            int studentId,
            int taskId) {
        this.studentId = studentId;
        this.taskId = taskId;
    }

    public StudentTaskDto toDto(){
        StudentTaskDto dto = new StudentTaskDto(taskId, studentId);
        return dto;
    }
}
