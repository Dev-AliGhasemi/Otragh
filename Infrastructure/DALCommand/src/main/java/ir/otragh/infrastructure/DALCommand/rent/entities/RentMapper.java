package ir.otragh.infrastructure.DALCommand.rent.entities;

import ir.otragh.core.domain.rents.entities.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentMapper {

    RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);

    @Mapping(source = ,target = )
    Rent rentToDataRent(ir.otragh.infrastructure.DALCommand.rent.entities.Rent rent);

}
