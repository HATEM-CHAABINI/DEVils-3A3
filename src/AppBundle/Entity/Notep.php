<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Notep
 *
 * @ORM\Table(name="notep", indexes={@ORM\Index(name="ref_pub", columns={"ref_pub"})})
 * @ORM\Entity
 */
class Notep
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="username", type="string", length=50, nullable=false)
     */
    private $username;

    /**
     * @var integer
     *
     * @ORM\Column(name="note", type="integer", nullable=false)
     */
    private $note;

    /**
     * @var \Publication
     *
     * @ORM\ManyToOne(targetEntity="Publication")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ref_pub", referencedColumnName="reference")
     * })
     */
    private $refPub;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set username
     *
     * @param string $username
     *
     * @return Notep
     */
    public function setUsername($username)
    {
        $this->username = $username;

        return $this;
    }

    /**
     * Get username
     *
     * @return string
     */
    public function getUsername()
    {
        return $this->username;
    }

    /**
     * Set note
     *
     * @param integer $note
     *
     * @return Notep
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return integer
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set refPub
     *
     * @param \AppBundle\Entity\Publication $refPub
     *
     * @return Notep
     */
    public function setRefPub(\AppBundle\Entity\Publication $refPub = null)
    {
        $this->refPub = $refPub;

        return $this;
    }

    /**
     * Get refPub
     *
     * @return \AppBundle\Entity\Publication
     */
    public function getRefPub()
    {
        return $this->refPub;
    }
}
