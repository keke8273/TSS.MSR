package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command allows an object to be encrypted using the symmetric encryption values of
 *  a Storage Key. After encryption, the object may be loaded and used in the new
 *  hierarchy. The imported object (duplicate) may be singly encrypted, multiply
 *  encrypted, or unencrypted.
 */
public class TPM2_Import_REQUEST extends TpmStructure
{
    /** The handle of the new parent for the object
     *  Auth Index: 1
     *  Auth Role: USER
     */
    public TPM_HANDLE parentHandle;
    
    /** The optional symmetric encryption key used as the inner wrapper for duplicate
     *  If symmetricAlg is TPM_ALG_NULL, then this parameter shall be the Empty Buffer.
     */
    public byte[] encryptionKey;
    
    /** The public area of the object to be imported
     *  This is provided so that the integrity value for duplicate and the object attributes
     *  can be checked.
     *  NOTE Even if the integrity value of the object is not checked on input, the object
     *  Name is required to create the integrity value for the imported object.
     */
    public TPMT_PUBLIC objectPublic;
    
    /** The symmetrically encrypted duplicate object that may contain an inner symmetric wrapper  */
    public TPM2B_PRIVATE duplicate;
    
    /** The seed for the symmetric key and HMAC key
     *  inSymSeed is encrypted/encoded using the algorithms of newParent.
     */
    public byte[] inSymSeed;
    
    /** Definition for the symmetric algorithm to use for the inner wrapper
     *  If this algorithm is TPM_ALG_NULL, no inner wrapper is present and encryptionKey shall
     *  be the Empty Buffer.
     */
    public TPMT_SYM_DEF_OBJECT symmetricAlg;
    
    public TPM2_Import_REQUEST() { parentHandle = new TPM_HANDLE(); }
    
    /** @param _parentHandle The handle of the new parent for the object
     *         Auth Index: 1
     *         Auth Role: USER
     *  @param _encryptionKey The optional symmetric encryption key used as the inner wrapper
     *  for duplicate
     *         If symmetricAlg is TPM_ALG_NULL, then this parameter shall be the Empty Buffer.
     *  @param _objectPublic The public area of the object to be imported
     *         This is provided so that the integrity value for duplicate and the object
     *         attributes can be checked.
     *         NOTE Even if the integrity value of the object is not checked on input, the object
     *         Name is required to create the integrity value for the imported object.
     *  @param _duplicate The symmetrically encrypted duplicate object that may contain an inner
     *         symmetric wrapper
     *  @param _inSymSeed The seed for the symmetric key and HMAC key
     *         inSymSeed is encrypted/encoded using the algorithms of newParent.
     *  @param _symmetricAlg Definition for the symmetric algorithm to use for the inner wrapper
     *         If this algorithm is TPM_ALG_NULL, no inner wrapper is present and encryptionKey
     *         shall be the Empty Buffer.
     */
    public TPM2_Import_REQUEST(TPM_HANDLE _parentHandle, byte[] _encryptionKey, TPMT_PUBLIC _objectPublic, TPM2B_PRIVATE _duplicate, byte[] _inSymSeed, TPMT_SYM_DEF_OBJECT _symmetricAlg)
    {
        parentHandle = _parentHandle;
        encryptionKey = _encryptionKey;
        objectPublic = _objectPublic;
        duplicate = _duplicate;
        inSymSeed = _inSymSeed;
        symmetricAlg = _symmetricAlg;
    }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(encryptionKey);
        buf.writeShort(objectPublic != null ? objectPublic.toTpm().length : 0);
        if (objectPublic != null)
            objectPublic.toTpm(buf);
        duplicate.toTpm(buf);
        buf.writeSizedByteBuf(inSymSeed);
        symmetricAlg.toTpm(buf);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _encryptionKeySize = buf.readShort() & 0xFFFF;
        encryptionKey = new byte[_encryptionKeySize];
        buf.readArrayOfInts(encryptionKey, 1, _encryptionKeySize);
        int _objectPublicSize = buf.readShort() & 0xFFFF;
        buf.structSize.push(buf.new SizedStructInfo(buf.curPos(), _objectPublicSize));
        objectPublic = TPMT_PUBLIC.fromTpm(buf);
        buf.structSize.pop();
        duplicate = TPM2B_PRIVATE.fromTpm(buf);
        int _inSymSeedSize = buf.readShort() & 0xFFFF;
        inSymSeed = new byte[_inSymSeedSize];
        buf.readArrayOfInts(inSymSeed, 1, _inSymSeedSize);
        symmetricAlg = TPMT_SYM_DEF_OBJECT.fromTpm(buf);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPM2_Import_REQUEST fromBytes (byte[] byteBuf) 
    {
        TPM2_Import_REQUEST ret = new TPM2_Import_REQUEST();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPM2_Import_REQUEST fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPM2_Import_REQUEST fromTpm (InByteBuf buf) 
    {
        TPM2_Import_REQUEST ret = new TPM2_Import_REQUEST();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_Import_REQUEST");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "parentHandle", parentHandle);
        _p.add(d, "byte", "encryptionKey", encryptionKey);
        _p.add(d, "TPMT_PUBLIC", "objectPublic", objectPublic);
        _p.add(d, "TPM2B_PRIVATE", "duplicate", duplicate);
        _p.add(d, "byte", "inSymSeed", inSymSeed);
        _p.add(d, "TPMT_SYM_DEF_OBJECT", "symmetricAlg", symmetricAlg);
    }
}

//<<<
