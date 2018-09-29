package br.com.fiap.webservice;
import java.util.Date;

import br.com.exemplo.vendas.apresentacao.service.Service;
import br.com.exemplo.vendas.negocio.model.vo.CompraVO;
import br.com.exemplo.vendas.negocio.model.vo.UsuarioVO;
import br.com.exemplo.vendas.util.exception.BusinessException;
import br.com.exemplo.vendas.util.exception.LayerException;
import br.com.exemplo.vendas.util.exception.SysException;

public class ExecutaServicos
{
	public Boolean inserirUsuario( UsuarioVO vo ) throws Exception
	{
		Boolean retorno = new Boolean( false ) ;
		try
		{	
			Service service = new Service( ) ;
			retorno = service.inserirUsuario( vo ) ;
		}
		catch ( LayerException e ) 
		{
			if ( e instanceof SysException )
			{
				throw new Exception( "erro interno no sistema: " + e.getMessage( ) ) ;
			}
			else
			{
				if ( e instanceof BusinessException ) 
				{
					throw new Exception( "erro de negócio: " + e.getMessage( ) ) ;
				}
			}
		}
		return retorno; 
	}
	
	public String enviaMensagem( CompraVO vo ) throws Exception 
	{
		String retorno = null ;
		
		vo.setCliente( 10000 ) ;
		vo.setData(  new Date( ) ) ;
		vo.setResponsavel( "enviando um teste" ) ;

		try
		{	
			Service service = new Service( );
			retorno = service.enviarCompra( vo ) ;
		}
		catch ( LayerException e ) 
		{
			if ( e instanceof SysException )
			{
				throw new Exception( "erro interno no sistema: " + e.getMessage( ) ) ;
			}
			else
			{
				if ( e instanceof BusinessException ) 
				{
					throw new Exception( "erro de negócio: " + e.getMessage( ) ) ;
				}
			}
		}
		return retorno ;
	}
}
